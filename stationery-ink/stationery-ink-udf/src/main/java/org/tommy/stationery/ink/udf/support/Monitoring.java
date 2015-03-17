package org.tommy.stationery.ink.udf.support;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Monitoring {
	
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
	
	public static String isFiltered(String msg, String[] errorWordSet) {
        for (String errorWord : errorWordSet) {
                if ( msg.toUpperCase().contains(errorWord.toUpperCase())) return "FILTER";
        }

        return "NO_FILTER";
	}
	
    public static String sendNoti(String group, String title, String level, String host, String path, String message) {
        Calendar calendar = Calendar.getInstance();
        String date = dateFormat.format(calendar.getTime());
        String msg = "[" + title + "]" + "\n"
                + "*레벨: " + level + "\n"
                + "*서버: " + host + "\n"
                + "*장애시간: " + date + "\n"
                + "*대상: " + path + "\n"
                + "*내용: " + message + "\n"
                + "*장애해결 : "  + "\n"
                + "   1. 해당서버의 로그를 확인하고 잡의 상태를 확인한다." + "\n"
                + "   2. http://play.daumcorp.com/display/bizdmp/119 장애대응페이지를 참고한다.";
        InkKakaoAlert.kakaoAlert(group, msg);
        return msg;
    }

	public static String sendNotiRealtimeReport(String disable, String group, String hmaster, String hzk, String[] targets, String[] targetNames, String[] targetMans, String host) {
		if ("disable".equals(disable)) {
			return "";
		}
		
		Configuration config = HBaseConfiguration.create();
        config.clear();
        config.set("hbase.master", hmaster);
        config.set("hbase.zookeeper.quorum", hzk);
        config.set("hbase.zookeeper.property.clientPort","2181");
       
        Calendar calendar = Calendar.getInstance();
        String date = dateFormat.format(calendar.getTime());

        String msg = "";
        HTable table = null;
		try {
			table = new HTable(config, "clix_summary_member");
		} catch (IOException e1) {
			msg = e1.getMessage();
            InkKakaoAlert.kakaoAlert(group, msg);
			return msg;
		}
		
        ResultScanner scanner = null;
        
        for (int i=0;i<targets.length;i++) {
                String target = targets[i];
                
                try {
	                    boolean isError = false;
	                    for (int p=0;p<9;p++) {
	                    	Scan scan = new Scan();
	                    	scan.setStartRow(Bytes.toBytes("0" + p + "_" + date + "_00"));
	                    	scan.setStopRow(Bytes.toBytes("0" + p + "_" + date + "_ff"));
	                    	scan.addColumn(Bytes.toBytes("h"), Bytes.toBytes(target));
	                    	scan.setMaxResultSize(1);
	                    	
	                    	scanner = table.getScanner(scan);
	                    	
	                    	Result result = null;
	                    	if ((result = scanner.next()) == null) {
	                    		isError = true;
	                        } else {
	                            isError = false;
	                            break;
	                        }
	                    }
	                    
	                    
                        if (isError == true) {
                                msg = "[실시간 레포트문제발견]" + "\n"
                                                + "*서버: " + host + "\n"
                                                + "*장애시간: " + date + "\n"
                                                + "*대상: " + targetNames[i] + "\n"
                                                + "*내용: 실시간레포트 [" + targetNames[i] + "] 데이터가 집계안됨." + "\n"
                                                + "*관련자: " + targetMans[i] + "님" + "\n"
                                                + "*장애해결 : "  + "\n"
                                                + "   1. MQ/KAFKA 메세지큐의 상태를 본다." + "\n"
                                                + "   2. http://10.30.180.15:8080 접속하여 스톰상태를 본다." + "\n"
                                                + "   3. http://play.daumcorp.com/display/bizdmp/119 장애대응페이지를 참고한다. 그래도 안되면!! 끝!!";
                            InkKakaoAlert.kakaoAlert(group, msg);
                        }
                        
                } catch(Exception e) {
                    msg = "[실시간 레포트문제발견] -" + host + "-현재시간(" + date + ")에 모니터링이 돌지않았습니다.";
                    InkKakaoAlert.kakaoAlert(group, msg);
                }
        }
        
        if (scanner != null) {
  	      scanner.close();
  	    }
  	    if (table != null) {
  	      try {
  	    	table.close();
  	      } catch (IOException e) {
  	      }
  	    }
  	    
  	    return msg;
	}
}
