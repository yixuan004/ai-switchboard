package cn.edu.bupt.aiswitchboard.common;

import java.io.Serializable;


public enum ResponseCode {
    SUCCESS(200),
    UNKNOWNERROR(500);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
