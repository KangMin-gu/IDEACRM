package com.crud.ideacrm.crud.dto;

import com.crud.ideacrm.crud.util.ContactInfo;

public class ContactInfoDto {

    private String ip;
    private String header;
    private String agent;
    private String browser;
    private String os;
    private String device;

    public ContactInfoDto () {}

    public ContactInfoDto(String ip, String header, String agent, String browser, String os, String device) {
        this.ip = ip;
        this.header = header;
        this.agent = agent;
        this.browser = browser;
        this.os = os;
        this.device = device;
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
}
