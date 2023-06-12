package cn.edu.bupt.aiswitchboard.model;

import io.swagger.annotations.ApiModelProperty;

public class TextClassifyPredictRequest {
    @ApiModelProperty(value = "场景名称", example = "test")
    private String sceneName;
    @ApiModelProperty(value = "待预测文本", example = "帮我查一下刘Java的电话号码")
    private String text;

    public TextClassifyPredictRequest() {
    }

    public TextClassifyPredictRequest(String sceneName, String text) {
        this.sceneName = sceneName;
        this.text = text;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean check() {
        // 非空检查
        if (this.sceneName == null ||  this.text == null) {
            return false;
        }
        return true;
    }

}
