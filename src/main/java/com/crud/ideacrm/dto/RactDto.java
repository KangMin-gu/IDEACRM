package com.crud.ideacrm.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RactDto {

    private int ractno;
    private int serviceno;
    private String ractdate;
    private int sendyn;
    private int ractowner;
    private String ractdesc;
    private String filesearchkey;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;
    private int siteid;
    private int ractcode;
    private List<MultipartFile> ractfile; //Spring 에서 파일 업로드 처리하기 위해

    public RactDto() {}

    public RactDto(int ractno, int serviceno, String ractdate, int sendyn, int ractowner, String ractdesc,
                   String filesearchkey, String regdate, int reguser, String edtdate, int edtuser, int siteid, int ractcode,
                   List<MultipartFile> ractfile) {
        super();
        this.ractno = ractno;
        this.serviceno = serviceno;
        this.ractdate = ractdate;
        this.sendyn = sendyn;
        this.ractowner = ractowner;
        this.ractdesc = ractdesc;
        this.filesearchkey = filesearchkey;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.siteid = siteid;
        this.ractcode = ractcode;
        this.ractfile = ractfile;
    }

    public int getRactno() {
        return ractno;
    }

    public void setRactno(int ractno) {
        this.ractno = ractno;
    }

    public int getServiceno() {
        return serviceno;
    }

    public void setServiceno(int serviceno) {
        this.serviceno = serviceno;
    }

    public String getRactdate() {
        return ractdate;
    }

    public void setRactdate(String ractdate) {
        this.ractdate = ractdate;
    }

    public int getSendyn() {
        return sendyn;
    }

    public void setSendyn(int sendyn) {
        this.sendyn = sendyn;
    }

    public int getRactowner() {
        return ractowner;
    }

    public void setRactowner(int ractowner) {
        this.ractowner = ractowner;
    }

    public String getRactdesc() {
        return ractdesc;
    }

    public void setRactdesc(String ractdesc) {
        this.ractdesc = ractdesc;
    }

    public String getFilesearchkey() {
        return filesearchkey;
    }

    public void setFilesearchkey(String filesearchkey) {
        this.filesearchkey = filesearchkey;
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

    public int getRactcode() {
        return ractcode;
    }

    public void setRactcode(int ractcode) {
        this.ractcode = ractcode;
    }

    public List<MultipartFile> getRactfile() {
        return ractfile;
    }

    public void setRactfile(List<MultipartFile> ractfile) {
        this.ractfile = ractfile;
    }

}
