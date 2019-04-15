package com.crud.ideacrm.dto;

public class KakaoDto {
    private String kakaono;
    private String plusfriend;
    private int kkoserviceno;
    private String kkotelno;
    private int kkogubun;
    private String siteid;
    private int reguser;
    private String regdate;
    private int edtuser;
    private String edtdate;

    public KakaoDto(){};

    public KakaoDto(String kakaono, String plusfriend, int kkoserviceno, String kkotelno, int kkogubun, String siteid, int reguser, String regdate, int edtuser, String edtdate) {
        this.kakaono = kakaono;
        this.plusfriend = plusfriend;
        this.kkoserviceno = kkoserviceno;
        this.kkotelno = kkotelno;
        this.kkogubun = kkogubun;
        this.siteid = siteid;
        this.reguser = reguser;
        this.regdate = regdate;
        this.edtuser = edtuser;
        this.edtdate = edtdate;
    }

    public String getKakaono() {
        return kakaono;
    }

    public void setKakaono(String kakaono) {
        this.kakaono = kakaono;
    }

    public String getPlusfriend() {
        return plusfriend;
    }

    public void setPlusfriend(String plusfriend) {
        this.plusfriend = plusfriend;
    }

    public int getKkoserviceno() {
        return kkoserviceno;
    }

    public void setKkoserviceno(int kkoserviceno) {
        this.kkoserviceno = kkoserviceno;
    }

    public String getKkotelno() {
        return kkotelno;
    }

    public void setKkotelno(String kkotelno) {
        this.kkotelno = kkotelno;
    }

    public int getKkogubun() {
        return kkogubun;
    }

    public void setKkogubun(int kkogubun) {
        this.kkogubun = kkogubun;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
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
}
