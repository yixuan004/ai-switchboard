package cn.edu.bupt.aiswitchboard.service;

import cn.edu.bupt.aiswitchboard.client.ThriftClient;
import cn.edu.bupt.aiswitchboard.config.ApplicationConfig;
import cn.edu.bupt.aiswitchboard.model.TextClassifyPredictRequest;
import cn.edu.bupt.aiswitchboard.utils.ThriftClientSingleton;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextClassifyServiceImpl implements TextClassifyService {

    // 注入Config
    private final ApplicationConfig applicationConfig;
    public TextClassifyServiceImpl(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }


    @Override
    public Object predict(TextClassifyPredictRequest requestParameters) {
        // 制作初始值，并添加透传信息
        Map<String, Object> data = new HashMap<>();
        data.put("sceneName", requestParameters.getSceneName());
        data.put("text", requestParameters.getText());

        String sceneName = requestParameters.getSceneName();
        String text = requestParameters.getText();

        ThriftClientSingleton.getInstance().callPythonService(sceneName, text);

        return data;
    }

}
