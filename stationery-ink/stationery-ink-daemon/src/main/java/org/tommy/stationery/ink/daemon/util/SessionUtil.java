package org.tommy.stationery.ink.daemon.util;

import net.hydromatic.linq4j.Linq4j;
import org.antlr.runtime.RecognitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.util.LinqQuery;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.cluster.Session;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 15. 4. 8..
 */

@Component
public class SessionUtil {
    private final static String COMMIT_QUERY = "commit;";
    private Map<String, Session> sessions = new HashMap<String, Session>();

    @Autowired
    ConfigProperties configProperties;

    public boolean isCommit(String sessionId, String sql) throws InkException {
        if (sessions.containsKey(sessionId) == false) {
            throw new InkException(MessageEnum.EMPTY_SQL_COMMIT);
        }

        if (COMMIT_QUERY.equals(sql)) {
            Session session = sessions.get(sessionId);
            if ((session.getLifeTime() + Integer.valueOf(configProperties.getString(SettingEnum.SESSION_TIME_OUT))) < System.currentTimeMillis()) {
                sessions.remove(sessionId);
                throw new InkException(MessageEnum.SESSION_TIME_OUT + ":" + configProperties.getString(SettingEnum.SESSION_TIME_OUT) + "ms");
            }
            sessions.remove(sessionId);
            return true;
        }
        return false;
    }

    //session sql process.
    public String getSessionConvSql(String sessionId, List<BaseStatement> statements, String sql) throws InkException, RecognitionException {
        List<BaseStatement> useStatements = Linq4j.asEnumerable(statements).where(LinqQuery.USE_STATEMENT_GROUP_FILTER).toList();
        String useSql = null;
        if (useStatements != null && useStatements.size() >= 1) {
            BaseStatement baseStatement = useStatements.get(useStatements.size() - 1);
            useSql = sql;
        }

        Session session = getQueryBySession(sessionId, sql, useSql);
        if (isCommit(sessionId, sql)) {
            sql = session.getSql();
        } else {
            if (!session.getUseSql().equals(sql)) {
                sql = session.getUseSql() + sql;
            }
        }
        return sql;
    }
    
    public Session getQueryBySession(String sessionId, String sql, String useSql) throws InkException {

        Session session = null;
        if (sessions.containsKey(sessionId)) {
            session = sessions.get(sessionId);
            session.setSql(session.getSql() + sql);
        } else {
            session = new Session();
            session.setSessionId(sessionId);
            if (useSql != null) {
                session.setUseSql(useSql);
            }
            session.setSql(sql);
            session.setLifeTime(System.currentTimeMillis());
        }
        sessions.put(sessionId, session);
        return session;
    }
}
