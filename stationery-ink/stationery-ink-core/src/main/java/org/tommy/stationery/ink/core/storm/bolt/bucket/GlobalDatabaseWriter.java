package org.tommy.stationery.ink.core.storm.bolt.bucket;

import com.google.common.collect.Queues;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.BlockingDeque;

public class GlobalDatabaseWriter extends AbstractExecutionThreadService {
    public static Logger logger = LoggerFactory.getLogger(GlobalDatabaseWriter.class);

	  static class WriteCtx {
	    public final String sql;
	    public WriteCtx(String sql) {
	      this.sql = sql;
	    }
	  }

	  private int commitInteval = 500;
	  private Integer commitCnt = 0;
	  private final DataSource dataSource;
	  private final BlockingDeque<WriteCtx> deque = Queues.newLinkedBlockingDeque();
	  private Statement statement = null;
	  private Connection connection = null;
	  
	  /**
	   * ctor
	 * @throws java.sql.SQLException
	   */
	  public GlobalDatabaseWriter(DataSource dataSource, int commitInteval) throws SQLException {
	    this.dataSource = dataSource;
	    this.commitInteval = commitInteval;
	    connection = dataSource.getConnection();
		connection.setAutoCommit(false);
		statement = connection.createStatement();
	  }
	  
	  /**
	   * writeAsync
	   */
	  public void writeAsync(String sql) {
	    deque.addLast(new WriteCtx(sql));
	  }
	  
	  @Override
	  protected void startUp() throws Exception {
	  }
	  
	  @Override
	  protected void shutDown() throws Exception {
          if (connection != null) {
              connection.commit();
              connection.close();
          }
	  }
	  
	  @Override
	  protected void triggerShutdown() {
	    deque.addLast(new WriteCtx(""));
	  }
	  
	  @Override
	  protected void run() throws Exception {
	    while (isRunning()) {
	      WriteCtx writeCtx = deque.takeFirst();
	      String sql = writeCtx.sql;
	      if (!"".equals(writeCtx.sql)) { // sentinel value
	        try {
	          // db write
                synchronized (commitCnt) {
                    commitCnt++;
                    statement.execute(sql);
                    if (commitCnt > commitInteval) {
                        commitCnt = 0;
                        connection.commit();
                        logger.info("DATABASE WRITER SIZE: " + deque.size());
                    }
                }
	        } catch (Exception e) {
	          //deque.putFirst(writeCtx); // undo
	          Thread.sleep(1);
	        }
	      }
	    }
	  }
	}
