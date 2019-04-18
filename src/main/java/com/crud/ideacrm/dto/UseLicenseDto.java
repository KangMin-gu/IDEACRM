package com.crud.ideacrm.dto;

public class UseLicenseDto {

    private String siteid;
    private int licenseid;
    private int isdelete;
    private int licensecnt;

    public UseLicenseDto(){};

    public UseLicenseDto(String siteid, int licenseid, int isdelete, int licensecnt) {
        this.siteid = siteid;
        this.licenseid = licenseid;
        this.isdelete = isdelete;
        this.licensecnt = licensecnt;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public int getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(int licenseid) {
        this.licenseid = licenseid;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public int getLicensecnt() {
        return licensecnt;
    }

    public void setLicensecnt(int licensecnt) {
        this.licensecnt = licensecnt;
    }
}
