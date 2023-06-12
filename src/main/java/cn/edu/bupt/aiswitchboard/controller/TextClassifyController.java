package cn.edu.bupt.aiswitchboard.controller;


import cn.edu.bupt.aiswitchboard.common.Response;
import cn.edu.bupt.aiswitchboard.common.ResponseCode;
import cn.edu.bupt.aiswitchboard.common.ResponseMessage;
import cn.edu.bupt.aiswitchboard.model.NameFinderFindRequest;
import cn.edu.bupt.aiswitchboard.model.TextClassifyPredictRequest;
import cn.edu.bupt.aiswitchboard.service.NameFinderServiceImpl;
import cn.edu.bupt.aiswitchboard.service.TextClassifyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("textclassify这个namespace主要用来进行文本的分类操作，和python程序间执行thrift RPC调用")
@RequestMapping("/textclassify")
public class TextClassifyController {

    @Autowired
    private TextClassifyServiceImpl textClassifyService;

    @ApiOperation("文本分类分类接口")
    @PostMapping("/predict")
    public Response<Object> find(@RequestBody TextClassifyPredictRequest textClassifyPredictRequest) {
        Response<Object> resp = new Response<>();  // 初始化返回值
        // 在Controller层检查接口参数是否满足要求
        if (!textClassifyPredictRequest.check()) {
            resp.update(ResponseCode.UNKNOWNERROR.getCode(), ResponseMessage.UNKNOWNERROR.getMessage(), "输入字段不符合要求，请检查");
            return resp;
        }
        // 进入Service层处理
        Object data = textClassifyService.predict(textClassifyPredictRequest);
        resp.update(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage(), data);
        return resp;
    }

}
