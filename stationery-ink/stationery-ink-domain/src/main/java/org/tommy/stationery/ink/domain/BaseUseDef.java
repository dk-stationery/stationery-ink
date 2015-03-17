package org.tommy.stationery.ink.domain;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 3. 12..
 */
public class BaseUseDef implements Serializable {
    private static final long serialVersionUID = 367827348685216102L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
