package com.crud.ideacrm.dto;

public class ServiceDeliveryDto {
    private String conveyno;
    private String serviceno;
    private int prevowner;
    private int nextowner;
    private int conveyreason;
    private String conveydate;
    private String conveydesc;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;
    private int siteid;

    public ServiceDeliveryDto(){};

    public ServiceDeliveryDto(String conveyno, String serviceno, int prevowner, int nextowner, int conveyreason, String conveydate, String conveydesc, String regdate, int reguser, String edtdate, int edtuser, int siteid) {
        this.conveyno = conveyno;
        this.serviceno = serviceno;
        this.prevowner = prevowner;
        this.nextowner = nextowner;
        this.conveyreason = conveyreason;
        this.conveydate = conveydate;
        this.conveydesc = conveydesc;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.siteid = siteid;
    }

    public String getConveyno() {
        return conveyno;
    }

    public void setConveyno(String conveyno) {
        this.conveyno = conveyno;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public int getPrevowner() {
        return prevowner;
    }

    public void setPrevowner(int prevowner) {
        this.prevowner = prevowner;
    }

    public int getNextowner() {
        return nextowner;
    }

    public void setNextowner(int nextowner) {
        this.nextowner = nextowner;
    }

    public int getConveyreason() {
        return conveyreason;
    }

    public void setConveyreason(int conveyreason) {
        this.conveyreason = conveyreason;
    }

    public String getConveydate() {
        return conveydate;
    }

    public void setConveydate(String conveydate) {
        this.conveydate = conveydate;
    }

    public String getConveydesc() {
        return conveydesc;
    }

    public void setConveydesc(String conveydesc) {
        this.conveydesc = conveydesc;
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

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }
}
