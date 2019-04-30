package com.crud.ideacrm.crud.dto;

import com.crud.ideacrm.crud.util.ContactInfo;

public class ContactInfoDto {

    private int userno;
    private String ip;
    private String header;
    private String agent;
    private String browser;
    private String os;
    private String device;
    private String sessionid;
    private int siteid;

    public ContactInfoDto () {}

    public ContactInfoDto(int userno, String ip, String header, String agent, String browser, String os, String device, String sessionid, int siteid) {
        this.userno = userno;
        this.ip = ip;
        this.header = header;
        this.agent = agent;
        this.browser = browser;
        this.os = os;
        this.device = device;
        this.sessionid = sessionid;
        this.siteid = siteid;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }
}
