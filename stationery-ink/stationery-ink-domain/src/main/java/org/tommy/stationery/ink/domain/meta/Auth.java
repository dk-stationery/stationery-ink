package org.tommy.stationery.ink.domain.meta;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 6. 18..
 */
public class Auth implements Serializable {
    private String user;
    private String password;
    private String grant;

    public Auth() {

    }

    public Auth(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }
}
