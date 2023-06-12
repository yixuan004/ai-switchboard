package cn.edu.bupt.aiswitchboard.service;

import cn.edu.bupt.aiswitchboard.model.TextClassifyPredictRequest;

public interface TextClassifyService {
    Object predict(TextClassifyPredictRequest requestParameters);
}
