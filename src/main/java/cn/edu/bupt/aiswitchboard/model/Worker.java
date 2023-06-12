package cn.edu.bupt.aiswitchboard.model;

public class Worker {
    private Long id;
    private String corpid;
    private String dep;
    private String per;
    private String extension;
    private String directline;
    private String mandarinPer;
    private String mandarinStripPer;
    private String mandarinDep;
    private String mandarinStripDep;
    private String mandarinSet;
    private String mandarin;
    private String mandarinStrip;

    public Worker() {
    }

    public Worker(String corpid, String dep, String per, String extension, String directline, String mandarinPer, String mandarinStripPer, String mandarinDep, String mandarinStripDep, String mandarinSet, String mandarin, String mandarinStrip) {
        this.corpid = corpid;
        this.dep = dep;
        this.per = per;
        this.extension = extension;
        this.directline = directline;
        this.mandarinPer = mandarinPer;
        this.mandarinStripPer = mandarinStripPer;
        this.mandarinDep = mandarinDep;
        this.mandarinStripDep = mandarinStripDep;
        this.mandarinSet = mandarinSet;
        this.mandarin = mandarin;
        this.mandarinStrip = mandarinStrip;
    }

    public Worker(Long id, String corpid, String dep, String per, String extension, String directline, String mandarinPer, String mandarinStripPer, String mandarinDep, String mandarinStripDep, String mandarinSet, String mandarin, String mandarinStrip) {
        this.id = id;
        this.corpid = corpid;
        this.dep = dep;
        this.per = per;
        this.extension = extension;
        this.directline = directline;
        this.mandarinPer = mandarinPer;
        this.mandarinStripPer = mandarinStripPer;
        this.mandarinDep = mandarinDep;
        this.mandarinStripDep = mandarinStripDep;
        this.mandarinSet = mandarinSet;
        this.mandarin = mandarin;
        this.mandarinStrip = mandarinStrip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDirectline() {
        return directline;
    }

    public void setDirectline(String directline) {
        this.directline = directline;
    }

    public String getMandarinPer() {
        return mandarinPer;
    }

    public void setMandarinPer(String mandarinPer) {
        this.mandarinPer = mandarinPer;
    }

    public String getMandarinStripPer() {
        return mandarinStripPer;
    }

    public void setMandarinStripPer(String mandarinStripPer) {
        this.mandarinStripPer = mandarinStripPer;
    }

    public String getMandarinDep() {
        return mandarinDep;
    }

    public void setMandarinDep(String mandarinDep) {
        this.mandarinDep = mandarinDep;
    }

    public String getMandarinStripDep() {
        return mandarinStripDep;
    }

    public void setMandarinStripDep(String mandarinStripDep) {
        this.mandarinStripDep = mandarinStripDep;
    }

    public String getMandarinSet() {
        return mandarinSet;
    }

    public void setMandarinSet(String mandarinSet) {
        this.mandarinSet = mandarinSet;
    }

    public String getMandarin() {
        return mandarin;
    }

    public void setMandarin(String mandarin) {
        this.mandarin = mandarin;
    }

    public String getMandarinStrip() {
        return mandarinStrip;
    }

    public void setMandarinStrip(String mandarinStrip) {
        this.mandarinStrip = mandarinStrip;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", corpid='" + corpid + '\'' +
                ", dep='" + dep + '\'' +
                ", per='" + per + '\'' +
                ", extension='" + extension + '\'' +
                ", directline='" + directline + '\'' +
                ", mandarinPer='" + mandarinPer + '\'' +
                ", mandarinStripPer='" + mandarinStripPer + '\'' +
                ", mandarinDep='" + mandarinDep + '\'' +
                ", mandarinStripDep='" + mandarinStripDep + '\'' +
                ", mandarinSet='" + mandarinSet + '\'' +
                ", mandarin='" + mandarin + '\'' +
                ", mandarinStrip='" + mandarinStrip + '\'' +
                '}';
    }
}
