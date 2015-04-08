package org.tommy.stationery.ink.daemon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.domain.cluster.Session;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 4. 8..
 */

@Component
public class SessionUtil {

    private Map<String, Session> sessions = new HashMap<String, Session>();

    @Autowired
    ConfigProperties configProperties;

    public boolean isCommit(String sessionId, String sql) throws InkException {
        if (sessions.containsKey(sessionId) == false) {
            throw new InkException(MessageEnum.EMPTY_SQL_COMMIT);
        }

        if ("commit;".equals(sql)) {
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

    public Session getQueryBySession(String sessionId, String sql) throws InkException {

        Session session = null;
        if (sessions.containsKey(sessionId)) {
            session = sessions.get(sessionId);
            session.setSql(session.getSql() + sql);
        } else {
            session = new Session();
            session.setSessionId(sessionId);
            session.setSql(sql);
            session.setLifeTime(System.currentTimeMillis());
        }
        sessions.put(sessionId, session);
        return session;
    }
}
