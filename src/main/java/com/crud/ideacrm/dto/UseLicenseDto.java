package com.crud.ideacrm.dto;

import java.util.List;

public class UseLicenseDto {

    private String siteid;
    private int licenseno;
    private int isdelete;
    private int licensecnt;
    private int reguser;
    private String regdate;
    private int edtuser;
    private String edtdate;

    private List<UseLicenseDto> useLicenseDtoList;

    public UseLicenseDto(){};

    public UseLicenseDto(String siteid, int licenseno, int isdelete, int licensecnt, int reguser, String regdate, int edtuser, String edtdate, List<UseLicenseDto> useLicenseDtoList) {
        this.siteid = siteid;
        this.licenseno = licenseno;
        this.isdelete = isdelete;
        this.licensecnt = licensecnt;
        this.reguser = reguser;
        this.regdate = regdate;
        this.edtuser = edtuser;
        this.edtdate = edtdate;
        this.useLicenseDtoList = useLicenseDtoList;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public int getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(int licenseno) {
        this.licenseno = licenseno;
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

    public int getReguser() {
        return reguser;
    }

    public void setReguser(int reguser) {
        this.reguser = reguser;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getEdtuser() {
        return edtuser;
    }

    public void setEdtuser(int edtuser) {
        this.edtuser = edtuser;
    }

    public String getEdtdate() {
        return edtdate;
    }

    public void setEdtdate(String edtdate) {
        this.edtdate = edtdate;
    }

    public List<UseLicenseDto> getUseLicenseDtoList() {
        return useLicenseDtoList;
    }

    public void setUseLicenseDtoList(List<UseLicenseDto> useLicenseDtoList) {
        this.useLicenseDtoList = useLicenseDtoList;
    }
}
