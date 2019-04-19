package com.crud.ideacrm.crud.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MailDto {

    private int emaillogid;
    private int siteid;
    private String cstname;
    private String username;
    private String fromemail;
    private String toemail;
    private String subject;
    private String content;
    private String filesearchkey;
    private String rltdate;
    private int clickyn;
    private int linkyn;
    private int reserv;
    private int emailtype;
    private int rltcode;
    private int formatnum;
    private String custno;
    private int userno;
    private String linkurl;
    private List<MultipartFile> file; //Spring 에서 파일 업로드 처리하기 위해

    public MailDto(){}

    public MailDto(int emaillogid, int siteid, String cstname, String username, String fromemail, String toemail, String subject, String content, String filesearchkey, String rltdate, int clickyn, int linkyn, int reserv, int emailtype, int rltcode, int formatnum, String custno, int userno, String linkurl, List<MultipartFile> file) {
        this.emaillogid = emaillogid;
        this.siteid = siteid;
        this.cstname = cstname;
        this.username = username;
        this.fromemail = fromemail;
        this.toemail = toemail;
        this.subject = subject;
        this.content = content;
        this.filesearchkey = filesearchkey;
        this.rltdate = rltdate;
        this.clickyn = clickyn;
        this.linkyn = linkyn;
        this.reserv = reserv;
        this.emailtype = emailtype;
        this.rltcode = rltcode;
        this.formatnum = formatnum;
        this.custno = custno;
        this.userno = userno;
        this.linkurl = linkurl;
        this.file = file;
    }

    public int getEmaillogid() {
        return emaillogid;
    }

    public void setEmaillogid(int emaillogid) {
        this.emaillogid = emaillogid;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public String getCstname() {
        return cstname;
    }

    public void setCstname(String cstname) {
        this.cstname = cstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFromemail() {
        return fromemail;
    }

    public void setFromemail(String fromemail) {
        this.fromemail = fromemail;
    }

    public String getToemail() {
        return toemail;
    }

    public void setToemail(String toemail) {
        this.toemail = toemail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilesearchkey() {
        return filesearchkey;
    }

    public void setFilesearchkey(String filesearchkey) {
        this.filesearchkey = filesearchkey;
    }

    public String getRltdate() {
        return rltdate;
    }

    public void setRltdate(String rltdate) {
        this.rltdate = rltdate;
    }

    public int getClickyn() {
        return clickyn;
    }

    public void setClickyn(int clickyn) {
        this.clickyn = clickyn;
    }

    public int getLinkyn() {
        return linkyn;
    }

    public void setLinkyn(int linkyn) {
        this.linkyn = linkyn;
    }

    public int getReserv() {
        return reserv;
    }

    public void setReserv(int reserv) {
        this.reserv = reserv;
    }

    public int getEmailtype() {
        return emailtype;
    }

    public void setEmailtype(int emailtype) {
        this.emailtype = emailtype;
    }

    public int getRltcode() {
        return rltcode;
    }

    public void setRltcode(int rltcode) {
        this.rltcode = rltcode;
    }

    public int getFormatnum() {
        return formatnum;
    }

    public void setFormatnum(int formatnum) {
        this.formatnum = formatnum;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public List<MultipartFile> getFile() {
        return file;
    }

    public void setFile(List<MultipartFile> file) {
        this.file = file;
    }
}
