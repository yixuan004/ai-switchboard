package cn.edu.bupt.aiswitchboard.controller;

import cn.edu.bupt.aiswitchboard.common.Response;
import cn.edu.bupt.aiswitchboard.common.ResponseCode;
import cn.edu.bupt.aiswitchboard.common.ResponseMessage;
import cn.edu.bupt.aiswitchboard.exceptions.NotImplementedException;
import cn.edu.bupt.aiswitchboard.model.HelloJsonInputRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderFindRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderInsertRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderUpdateRequest;
import cn.edu.bupt.aiswitchboard.service.NameFinderServiceImpl;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    @ApiOperation("部门人名查找find接口，输入一句话和各种依赖资源，输出查找得到的人名-部门对应")
    @PostMapping("/match")
    public Response<Object> find(@RequestBody NameFinderFindRequest nameFinderFindRequest) {
        Response<Object> resp = new Response<>();  // 初始化返回值
        // 在Controller层检查接口参数是否满足要求
        if (!nameFinderFindRequest.check()) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), "输入字段不符合要求，请检查");
            return resp;
        }
        // 进入Service层处理
        try {
            Object data = nameFinderService.find(nameFinderFindRequest);
            resp.update(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage(), data);
        } catch (Exception e) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), e.getMessage());
            return resp;
        }
        return resp;
    }

    @ApiOperation("部门人名查找insert接口，可以将新用户的名称执行插入并更新数据库")
    @PostMapping("/insert")
    public Response<Object> insert(@RequestBody NameFinderInsertRequest nameFinderInsertRequest) {
        Response<Object> resp = new Response<>();  // 初始化返回值
        // 在Controller层检查接口参数是否满足要求
        if (!nameFinderInsertRequest.check()) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), "输入字段不符合要求，请检查");
            return resp;
        }
        // 进入Service层处理
        try {
            Object data = nameFinderService.insert(nameFinderInsertRequest);
            resp.update(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage(), data);
        } catch (DuplicateKeyException e) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), e.getMessage());
            return resp;
        } catch (NotImplementedException e) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), e.getMessage());
            return resp;
        }
        return resp;
    }

    @ApiOperation("部门人名查找update接口，可以重新加载数据库到内存中")
    @PostMapping("/update")
    public Response<Object> update(@RequestBody NameFinderUpdateRequest nameFinderUpdateRequest) {
        Response<Object> resp = new Response<>();  // 初始化返回值
        // 在Controller层检查接口参数是否满足要求
        if (!nameFinderUpdateRequest.check()) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), "输入字段不符合要求，请检查");
            return resp;
        }
        // 进入Service层处理
        try {
            Object data = nameFinderService.update(nameFinderUpdateRequest);
            resp.update(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage(), data);
        } catch (Exception e) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), e.getMessage());
        }

        return resp;
    }

}
