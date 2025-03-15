package com.stamasoftlab.java_bl_appclone;

public class RVoffers_ModelClass {

    public RVoffers_ModelClass(int ID, Integer mimageView_top, String mtitle, String mbtn) {
        this.ID = ID;
        this.mimageView_top = mimageView_top;
        this.mtitle = mtitle;
        this.mbtn = mbtn;
    }

    private int ID;
    private Integer mimageView_top;
    private String mtitle;
    private String mbtn;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getMimageView_top() {
        return mimageView_top;
    }

    public void setMimageView_top(Integer mimageView_top) {
        this.mimageView_top = mimageView_top;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMbtn() {
        return mbtn;
    }

    public void setMbtn(String mbtn) {
        this.mbtn = mbtn;
    }
}
