package org.tommy.stationery.ink.exception;

import org.tommy.stationery.ink.enums.MessageEnum;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class InkException extends Exception {
    public InkException(MessageEnum msg) {
        super(msg.getMessage());
    }

    public InkException(String msg) {
        super(msg);
    }
}
