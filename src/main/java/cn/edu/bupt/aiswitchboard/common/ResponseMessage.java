package cn.edu.bupt.aiswitchboard.common;

public enum ResponseMessage {
    SUCCESS("SUCCESS"),
    UNKNOWNERROR("UNKNOWN ERROR");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}