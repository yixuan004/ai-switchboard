package cn.edu.bupt.aiswitchboard.controller;

import cn.edu.bupt.aiswitchboard.common.Response;
import cn.edu.bupt.aiswitchboard.common.ResponseCode;
import cn.edu.bupt.aiswitchboard.common.ResponseMessage;
import cn.edu.bupt.aiswitchboard.model.HelloJsonInputRequest;
import cn.edu.bupt.aiswitchboard.service.NameFinderServiceImpl;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("namefinder这个namespace主要用来进行部门人名查找接口的相关操作")
@RequestMapping("/namefinder")
public class NameFinderController {

    @Autowired
    private NameFinderServiceImpl nameFinderService;

    @ApiOperation("部门人名查找接口，输入一句话和各种依赖资源，输出查找得到的人名-部门对应")
    @PostMapping("")
    public Response<Object> postJsonInput() {
        Response<Object> resp = new Response<>();

        List<Term> lst = HanLP.segment("你好，欢迎使用HanLP汉语处理包！");
        int a = nameFinderService.test(5);
        System.out.println("a: " + a);

        resp.update(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage(), null);
        return resp;
    }

}
