package cn.edu.bupt.aiswitchboard.controller;

import cn.edu.bupt.aiswitchboard.common.Response;
import cn.edu.bupt.aiswitchboard.common.ResponseCode;
import cn.edu.bupt.aiswitchboard.common.ResponseMessage;
import cn.edu.bupt.aiswitchboard.model.HelloJsonInputRequest;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api("hello接口用来进行测试")
@RequestMapping("/hello")
public class HelloController {
    @ApiOperation("测试post中json-body类型的数据输入")
    @PostMapping("/json-input")
    public Response<Object> postJsonInput(@RequestBody HelloJsonInputRequest helloJsonInputRequest) {
        Response<Object> resp = new Response<>();
        System.out.println(helloJsonInputRequest.toString());
        resp.update(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage(), null);
        return resp;
    }

    @ApiOperation("测试post中form-data类型的数据输入")
    @PostMapping("/form-input")
    public Response<Object> postFormInput(@RequestParam("name") String name,
                                          @RequestParam("age") Integer age,
                                          @RequestPart("file") MultipartFile file) {
        Response<Object> resp = new Response<>();
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("file: " + file);
        return resp;
    }
}