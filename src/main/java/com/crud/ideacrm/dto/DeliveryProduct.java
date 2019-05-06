package com.crud.ideacrm.dto;

public class DeliveryProduct {

    private int buyno;
    private String buyuser;
    private int reguser;
    private String regdate;
    private int edtdate;
    private int edtuser;
    private String addr1;
    private String addr2;
    private String addr3;
    private String addr;
    private String mobile1;
    private String mobile2;
    private String mobile3;
    private String mobile;
    private String homtel1;
    private String homtel2;
    private String homtel3;
    private String homtel;
    private int siteid;
    private String deliveryname;
    private int prdno;
    private int prdea;
    private int erpno;

    public DeliveryProduct(){}

    public DeliveryProduct(int buyno, String buyuser, int reguser, String regdate, int edtdate, int edtuser, String addr1, String addr2, String addr3, String addr, String mobile1, String mobile2, String mobile3, String mobile, String homtel1, String homtel2, String homtel3, String homtel, int siteid, String deliveryname, int prdno, int prdea, int erpno) {
        this.buyno = buyno;
        this.buyuser = buyuser;
        this.reguser = reguser;
        this.regdate = regdate;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.addr3 = addr3;
        this.addr = addr;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.mobile3 = mobile3;
        this.mobile = mobile;
        this.homtel1 = homtel1;
        this.homtel2 = homtel2;
        this.homtel3 = homtel3;
        this.homtel = homtel;
        this.siteid = siteid;
        this.deliveryname = deliveryname;
        this.prdno = prdno;
        this.prdea = prdea;
        this.erpno = erpno;
    }

    public int getBuyno() {
        return buyno;
    }

    public void setBuyno(int buyno) {
        this.buyno = buyno;
    }

    public String getBuyuser() {
        return buyuser;
    }

    public void setBuyuser(String buyuser) {
        this.buyuser = buyuser;
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

    public int getEdtdate() {
        return edtdate;
    }

    public void setEdtdate(int edtdate) {
        this.edtdate = edtdate;
    }

    public int getEdtuser() {
        return edtuser;
    }

    public void setEdtuser(int edtuser) {
        this.edtuser = edtuser;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getMobile3() {
        return mobile3;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHomtel1() {
        return homtel1;
    }

    public void setHomtel1(String homtel1) {
        this.homtel1 = homtel1;
    }

    public String getHomtel2() {
        return homtel2;
    }

    public void setHomtel2(String homtel2) {
        this.homtel2 = homtel2;
    }

    public String getHomtel3() {
        return homtel3;
    }

    public void setHomtel3(String homtel3) {
        this.homtel3 = homtel3;
    }

    public String getHomtel() {
        return homtel;
    }

    public void setHomtel(String homtel) {
        this.homtel = homtel;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public String getDeliveryname() {
        return deliveryname;
    }

    public void setDeliveryname(String deliveryname) {
        this.deliveryname = deliveryname;
    }

    public int getPrdno() {
        return prdno;
    }

    public void setPrdno(int prdno) {
        this.prdno = prdno;
    }

    public int getPrdea() {
        return prdea;
    }

    public void setPrdea(int prdea) {
        this.prdea = prdea;
    }

    public int getErpno() {
        return erpno;
    }

    public void setErpno(int erpno) {
        this.erpno = erpno;
    }
}
