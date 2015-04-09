package org.tommy.stationery.ink.domain.cluster;

/**
 * Created by kun7788 on 15. 4. 8..
 */
public class Session {
    private String sessionId;
    private long lifeTime;
    private String sql;
    private String useSql = "";

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(long lifeTime) {
        this.lifeTime = lifeTime;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getUseSql() {
        return useSql;
    }

    public void setUseSql(String useSql) {
        this.useSql = useSql;
    }
}
