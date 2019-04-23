package com.crud.ideacrm.dto;

public class UserCtiDto {

    private String userno;
    private String ctitelno;
    private String ctiid;
    private String ctipw;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;

    public UserCtiDto(){};

    public UserCtiDto(String userno, String ctitelno, String ctiid, String ctipw, String regdate, int reguser, String edtdate, int edtuser) {
        this.userno = userno;
        this.ctitelno = ctitelno;
        this.ctiid = ctiid;
        this.ctipw = ctipw;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getCtitelno() {
        return ctitelno;
    }

    public void setCtitelno(String ctitelno) {
        this.ctitelno = ctitelno;
    }

    public String getCtiid() {
        return ctiid;
    }

    public void setCtiid(String ctiid) {
        this.ctiid = ctiid;
    }

    public String getCtipw() {
        return ctipw;
    }

    public void setCtipw(String ctipw) {
        this.ctipw = ctipw;
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
}
