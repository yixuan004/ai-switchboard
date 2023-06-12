package cn.edu.bupt.aiswitchboard.exceptions;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        super("This method or feature is not implemented yet.");
    }
}