package cn.edu.bupt.aiswitchboard.model;

import io.swagger.annotations.ApiModelProperty;

public class NameFinderFindRequest {
    @ApiModelProperty(value = "需要查询的内容，如：找系统研发部的刘××", example = "系统集成研发部，杨过")
    private String content;
    @ApiModelProperty(value = "和数据库中相对应的企业id，如目前使用的20000001", example = "20000001")
    private String corpId;
    @ApiModelProperty(value = "任务标识字段，目前仅支持设置为test", example = "test")
    private String taskId;
    @ApiModelProperty(value = "标识使用方法的版本，在线实时分词/离线分词/内存加载三种方式，分别对应version1.0 2.0 3.0", example = "1.0")
    private String version;

    public NameFinderFindRequest() {
    }

    public NameFinderFindRequest(String content, String corpId, String taskId, String version) {
        this.content = content;
        this.corpId = corpId;
        this.taskId = taskId;
        this.version = version;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "NameFinderFindRequest{" +
                "content='" + content + '\'' +
                ", corpId='" + corpId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public boolean check() {
        // 非空检查
        if (this.content == null ||  this.corpId == null || this.taskId == null || this.version == null) {
            return false;
        }
        return true;
    }
}
