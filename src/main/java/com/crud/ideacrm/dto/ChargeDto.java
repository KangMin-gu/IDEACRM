package com.crud.ideacrm.dto;

public class ChargeDto {
    private int chargeno;
    private int smscharge;
    private int mmscharge;
    private int lmscharge;
    private int kakaocharge;
    private int emailcharge;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;
    private String siteid;

    public ChargeDto(){};

    public ChargeDto(int chargeno, int smscharge, int mmscharge, int lmscharge, int kakaocharge, int emailcharge, String regdate, int reguser, String edtdate, int edtuser, String siteid) {
        this.chargeno = chargeno;
        this.smscharge = smscharge;
        this.mmscharge = mmscharge;
        this.lmscharge = lmscharge;
        this.kakaocharge = kakaocharge;
        this.emailcharge = emailcharge;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.siteid = siteid;
    }

    public int getChargeno() {
        return chargeno;
    }

    public void setChargeno(int chargeno) {
        this.chargeno = chargeno;
    }

    public int getSmscharge() {
        return smscharge;
    }

    public void setSmscharge(int smscharge) {
        this.smscharge = smscharge;
    }

    public int getMmscharge() {
        return mmscharge;
    }

    public void setMmscharge(int mmscharge) {
        this.mmscharge = mmscharge;
    }

    public int getLmscharge() {
        return lmscharge;
    }

    public void setLmscharge(int lmscharge) {
        this.lmscharge = lmscharge;
    }

    public int getKakaocharge() {
        return kakaocharge;
    }

    public void setKakaocharge(int kakaocharge) {
        this.kakaocharge = kakaocharge;
    }

    public int getEmailcharge() {
        return emailcharge;
    }

    public void setEmailcharge(int emailcharge) {
        this.emailcharge = emailcharge;
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

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }
}
