package cn.edu.bupt.aiswitchboard.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    @ApiModelProperty(value = "响应状态码", example = "200, 500")
    private int code;
    private String message;
    private T data;

    public Response() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.message = ResponseMessage.SUCCESS.getMessage();
        this.data = null;
    }

    public void update(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
