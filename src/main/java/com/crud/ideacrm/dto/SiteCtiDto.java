package com.crud.ideacrm.dto;

import com.crud.ideacrm.crud.util.CodecUtil;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class SiteCtiDto {
    private String siteid;
    private String ip;
    private String socketip;
    private String port;
    private String telno;
    private int reguser;
    private String regdate;
    private int edtuser;
    private String edtdate;

    public SiteCtiDto(){};

    public SiteCtiDto(String siteid, String ip, String socketip, String port, String telno, int reguser, String regdate, int edtuser, String edtdate) {
        this.siteid = siteid;
        this.ip = ip;
        this.socketip = socketip;
        this.port = port;
        this.telno = telno;
        this.reguser = reguser;
        this.regdate = regdate;
        this.edtuser = edtuser;
        this.edtdate = edtdate;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSocketip() {
        return socketip;
    }

    public void setSocketip(String socketip) {
        this.socketip = socketip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
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
