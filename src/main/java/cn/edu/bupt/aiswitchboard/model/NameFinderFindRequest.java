package cn.edu.bupt.aiswitchboard.model;

import io.swagger.annotations.ApiModelProperty;

public class NameFinderFindRequest {
    @ApiModelProperty(value = "需要查询的内容，如：找系统研发部的刘××", example = "系统集成研发部，杨过")
    private String content;
    @ApiModelProperty(value = "和数据库中相对应的企业id，如目前使用的20000001", example = "20000001")
    private String corpId;
    @ApiModelProperty(value = "任务标识字段，目前仅支持设置为test", example = "test")
    private String taskId;

    public NameFinderFindRequest() {
    }

    public NameFinderFindRequest(String content, String corpId, String taskId) {
        this.content = content;
        this.corpId = corpId;
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "NameFinderFindRequest{" +
                "content='" + content + '\'' +
                ", corpId='" + corpId + '\'' +
                ", taskId='" + taskId + '\'' +
                '}';
    }


    public boolean check() {
        // 非空检查
        if (this.content == null ||  this.corpId == null || this.taskId == null) {
            return false;
        }
        return true;
    }
}
