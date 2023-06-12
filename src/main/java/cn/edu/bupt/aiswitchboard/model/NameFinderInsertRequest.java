package cn.edu.bupt.aiswitchboard.model;

import io.swagger.annotations.ApiModelProperty;

public class NameFinderInsertRequest {
    @ApiModelProperty(value = "待插入的企业Id", example = "20000001")
    private String corpId;
    @ApiModelProperty(value = "部门名称", example = "系统集成研发部")
    private String dep;
    @ApiModelProperty(value = "人名", example = "刘美团")
    private String per;

    public NameFinderInsertRequest() {
    }

    public NameFinderInsertRequest(String corpId, String dep, String per) {
        this.corpId = corpId;
        this.dep = dep;
        this.per = per;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public boolean check() {
        // 非空检查
        if (this.corpId == null ||  this.dep == null || this.per == null) {
            return false;
        }
        return true;
    }
}
