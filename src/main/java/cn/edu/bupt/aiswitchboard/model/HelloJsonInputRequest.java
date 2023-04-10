package cn.edu.bupt.aiswitchboard.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

public class HelloJsonInputRequest {
    @ApiModelProperty(value = "Integer类型输入", example = "123")
    private Integer a;
    @ApiModelProperty(value = "String类型输入", example = "helloworld")
    private String b;
    @ApiModelProperty(value = "List<Map<String, Integer>>类型输入", example = "[{\"hello\": 123}, {\"world\": 456}]")
    private List<Map<String, Integer>> c;

    public HelloJsonInputRequest() {
    }

    public HelloJsonInputRequest(Integer a, String b, List<Map<String, Integer>> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public List<Map<String, Integer>> getC() {
        return c;
    }

    public void setC(List<Map<String, Integer>> c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "HelloJsonInputRequest{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}
