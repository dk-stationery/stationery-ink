package org.tommy.stationery.ink.udf.domain;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public class KakaoAlert {
    private String channelGroupName;
    private String msg;

    public KakaoAlert(String channelGroupName, String msg) {
        this.channelGroupName = channelGroupName;
        this.msg = msg;
    }

    public String getChannelGroupName() {
        return channelGroupName;
    }

    public void setChannelGroupName(String channelGroupName) {
        this.channelGroupName = channelGroupName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
