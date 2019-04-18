package com.crud.ideacrm.dto;

public class LicenseDto {
    private int licenseno;
    private String licensename;
    private int licensecost;
    private int isdelete;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;

    public LicenseDto() {}

    public int getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(int licenseno) {
        this.licenseno = licenseno;
    }

    public String getLicensename() {
        return licensename;
    }

    public void setLicensename(String licensename) {
        this.licensename = licensename;
    }

    public int getLicensecost() {
        return licensecost;
    }

    public void setLicensecost(int licensecost) {
        this.licensecost = licensecost;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getReguser() {
        return reguser;
    }

    public void setReguser(int reguser) {
        this.reguser = reguser;
    }

    public String getEdtdate() {
        return edtdate;
    }

    public void setEdtdate(String edtdate) {
        this.edtdate = edtdate;
    }

    public int getEdtuser() {
        return edtuser;
    }

    public void setEdtuser(int edtuser) {
        this.edtuser = edtuser;
    }

    public LicenseDto(int licenseno, String licensename, int licensecost, int isdelete, String regdate, int reguser,
                      String edtdate, int edtuser) {
        super();
        this.licenseno = licenseno;
        this.licensename = licensename;
        this.licensecost = licensecost;
        this.isdelete = isdelete;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
    };
}
