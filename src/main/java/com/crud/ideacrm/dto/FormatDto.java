package com.crud.ideacrm.dto;

public class FormatDto {

    private String formatno;
    private String formatname;
    private String formatdesc;
    private int sendtype;
    private int usemenu;
    private int siteid;
    private int isdelete;
    private String kkoserviceno;
    private String kkotempleteno;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;

    public FormatDto(){};

    public FormatDto(String formatno, String formatname, String formatdesc, int sendtype, int usemenu, int siteid, int isdelete, String kkoserviceno, String kkotempleteno, String regdate, int reguser, String edtdate, int edtuser) {
        this.formatno = formatno;
        this.formatname = formatname;
        this.formatdesc = formatdesc;
        this.sendtype = sendtype;
        this.usemenu = usemenu;
        this.siteid = siteid;
        this.isdelete = isdelete;
        this.kkoserviceno = kkoserviceno;
        this.kkotempleteno = kkotempleteno;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
    }

    public String getFormatno() {
        return formatno;
    }

    public void setFormatno(String formatno) {
        this.formatno = formatno;
    }

    public String getFormatname() {
        return formatname;
    }

    public void setFormatname(String formatname) {
        this.formatname = formatname;
    }

    public String getFormatdesc() {
        return formatdesc;
    }

    public void setFormatdesc(String formatdesc) {
        this.formatdesc = formatdesc;
    }

    public int getSendtype() {
        return sendtype;
    }

    public void setSendtype(int sendtype) {
        this.sendtype = sendtype;
    }

    public int getUsemenu() {
        return usemenu;
    }

    public void setUsemenu(int usemenu) {
        this.usemenu = usemenu;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getKkoserviceno() {
        return kkoserviceno;
    }

    public void setKkoserviceno(String kkoserviceno) {
        this.kkoserviceno = kkoserviceno;
    }

    public String getKkotempleteno() {
        return kkotempleteno;
    }

    public void setKkotempleteno(String kkotempleteno) {
        this.kkotempleteno = kkotempleteno;
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
