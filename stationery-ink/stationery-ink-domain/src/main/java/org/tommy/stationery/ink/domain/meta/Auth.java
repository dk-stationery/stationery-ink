package org.tommy.stationery.ink.domain.meta;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 6. 18..
 */
public class Auth implements Serializable {
    private String authuser;
    private String authpassword;
    private String authgrant;

    public Auth() {

    }

    public Auth(String authuser, String authpassword) {
        this.authuser = authuser;
        this.authpassword = authpassword;
    }

    public String getAuthuser() {
        return authuser;
    }

    public void setAuthuser(String authuser) {
        this.authuser = authuser;
    }

    public String getAuthpassword() {
        return authpassword;
    }

    public void setAuthpassword(String authpassword) {
        this.authpassword = authpassword;
    }

    public String getAuthgrant() {
        return authgrant;
    }

    public void setAuthgrant(String authgrant) {
        this.authgrant = authgrant;
    }
}
