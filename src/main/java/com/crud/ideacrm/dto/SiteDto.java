package com.crud.ideacrm.dto;

import com.crud.ideacrm.crud.util.CodecUtil;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class SiteDto {

    private String siteid; //사이트 ID PK
    private String sitename; //회원사명
    private String bsno1; //사업자번호1
    private String bsno2; //사업자번호2
    private String bsno3; //사업자번호3
    private String incno1; //법인번호1
    private String incno2; //법인번호2
    private String addr1; //우편번호
    private String addr2; //주소1
    private String addr3; //주소2
    private String fregdate; //최초 가입일
    private String expirdate; //만료일
    private String telno1; //전화1
    private String telno2; //전화2
    private String telno3; //전화3
    private String faxtel1; //팩스1
    private String faxtel2; //팩스2
    private String faxtel3; //팩스3
    private String mobile1; //휴대폰1
    private String mobile2; //휴대폰2
    private String mobile3; //휴대폰3
    private String email; //이메일
    private String sitememo; //사이트메모
    //private MultipartFile sitelogo; //사이트로고
    private String sitelogo; //사이트로고
    private String bscond; //업종
    private String cotype; //업태
    private String bstype; //종목
    private String regdate; //등록일시
    private int reguser; //등록자
    private String edtdate; //수정일시
    private int edtuser; //수정자
    private String callname; //회사약어
    private String sitesize; //회사규모
    private String prsdname; // 대표자명
    private String adminid;
    private String adminpassword;
    private int isdelete; //서비스상태
    private int owner; // 담당자
    private String bsno;

    public SiteDto(){};

    public void setEncodingSiteDto() throws UnsupportedEncodingException, GeneralSecurityException {
        CodecUtil commonUtil = new CodecUtil();
        if(this.mobile1 != null && this.mobile1 != ""){ this.mobile1 = commonUtil.encoding(this.mobile1);}
        if(this.mobile2 != null && this.mobile2 != ""){ this.mobile2 = commonUtil.encoding(this.mobile2);}
        if(this.mobile3 != null && this.mobile3 != ""){ this.mobile3 = commonUtil.encoding(this.mobile3);}
        if(this.telno1 != null && this.telno1 != ""){ this.telno1 = commonUtil.encoding(this.telno1);}
        if(this.telno2 != null && this.telno2 != ""){ this.telno2 = commonUtil.encoding(this.telno2);}
        if(this.telno3 != null && this.telno3 != ""){ this.telno3 = commonUtil.encoding(this.telno3);}
        if(this.faxtel1 != null && this.faxtel1 != ""){ this.faxtel1 = commonUtil.encoding(this.faxtel1);}
        if(this.faxtel2 != null && this.faxtel2 != ""){ this.faxtel2 = commonUtil.encoding(this.faxtel2);}
        if(this.faxtel3 != null && this.faxtel3 != ""){ this.faxtel3 = commonUtil.encoding(this.faxtel3);}
        if(this.addr1 != null && this.addr1 != ""){ this.addr1 = commonUtil.encoding(this.addr1);}
        if(this.addr2 != null && this.addr2 != ""){ this.addr2 = commonUtil.encoding(this.addr2);}
        if(this.addr3 != null && this.addr3 != ""){ this.addr3 = commonUtil.encoding(this.addr3);}
        if(this.bsno1 != null && this.bsno1 != ""){ this.bsno1 = commonUtil.encoding(this.bsno1);}
        if(this.bsno2 != null && this.bsno2 != ""){ this.bsno2 = commonUtil.encoding(this.bsno2);}
        if(this.bsno3 != null && this.bsno3 != ""){ this.bsno3 = commonUtil.encoding(this.bsno3);}
        if(this.incno1 != null && this.incno1 != ""){ this.incno1 = commonUtil.encoding(this.incno1);}
        if(this.incno2 != null && this.incno2 != ""){ this.incno2 = commonUtil.encoding(this.incno2);}
        if(this.email != null && this.email != ""){ this.email = commonUtil.encoding(this.email); }
    }

    public SiteDto(String siteid, String sitename, String bsno1, String bsno2, String bsno3, String incno1, String incno2, String addr1, String addr2, String addr3, String fregdate, String expirdate, String telno1, String telno2, String telno3, String faxtel1, String faxtel2, String faxtel3, String mobile1, String mobile2, String mobile3, String email, String sitememo, String sitelogo, String bscond, String cotype, String bstype, String regdate, int reguser, String edtdate, int edtuser, String callname, String sitesize, String prsdname, String adminid, String adminpassword, int isdelete, int owner, String bsno) {
        this.siteid = siteid;
        this.sitename = sitename;
        this.bsno1 = bsno1;
        this.bsno2 = bsno2;
        this.bsno3 = bsno3;
        this.incno1 = incno1;
        this.incno2 = incno2;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.addr3 = addr3;
        this.fregdate = fregdate;
        this.expirdate = expirdate;
        this.telno1 = telno1;
        this.telno2 = telno2;
        this.telno3 = telno3;
        this.faxtel1 = faxtel1;
        this.faxtel2 = faxtel2;
        this.faxtel3 = faxtel3;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.mobile3 = mobile3;
        this.email = email;
        this.sitememo = sitememo;
        this.sitelogo = sitelogo;
        this.bscond = bscond;
        this.cotype = cotype;
        this.bstype = bstype;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.callname = callname;
        this.sitesize = sitesize;
        this.prsdname = prsdname;
        this.adminid = adminid;
        this.adminpassword = adminpassword;
        this.isdelete = isdelete;
        this.owner = owner;
        this.bsno = bsno;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getBsno1() {
        return bsno1;
    }

    public void setBsno1(String bsno1) {
        this.bsno1 = bsno1;
    }

    public String getBsno2() {
        return bsno2;
    }

    public void setBsno2(String bsno2) {
        this.bsno2 = bsno2;
    }

    public String getBsno3() {
        return bsno3;
    }

    public void setBsno3(String bsno3) {
        this.bsno3 = bsno3;
    }

    public String getIncno1() {
        return incno1;
    }

    public void setIncno1(String incno1) {
        this.incno1 = incno1;
    }

    public String getIncno2() {
        return incno2;
    }

    public void setIncno2(String incno2) {
        this.incno2 = incno2;
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

    public String getFregdate() {
        return fregdate;
    }

    public void setFregdate(String fregdate) {
        this.fregdate = fregdate;
    }

    public String getExpirdate() {
        return expirdate;
    }

    public void setExpirdate(String expirdate) {
        this.expirdate = expirdate;
    }

    public String getTelno1() {
        return telno1;
    }

    public void setTelno1(String telno1) {
        this.telno1 = telno1;
    }

    public String getTelno2() {
        return telno2;
    }

    public void setTelno2(String telno2) {
        this.telno2 = telno2;
    }

    public String getTelno3() {
        return telno3;
    }

    public void setTelno3(String telno3) {
        this.telno3 = telno3;
    }

    public String getFaxtel1() {
        return faxtel1;
    }

    public void setFaxtel1(String faxtel1) {
        this.faxtel1 = faxtel1;
    }

    public String getFaxtel2() {
        return faxtel2;
    }

    public void setFaxtel2(String faxtel2) {
        this.faxtel2 = faxtel2;
    }

    public String getFaxtel3() {
        return faxtel3;
    }

    public void setFaxtel3(String faxtel3) {
        this.faxtel3 = faxtel3;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitememo() {
        return sitememo;
    }

    public void setSitememo(String sitememo) {
        this.sitememo = sitememo;
    }

    public String getSitelogo() {
        return sitelogo;
    }

    public void setSitelogo(String sitelogo) {
        this.sitelogo = sitelogo;
    }

    public String getBscond() {
        return bscond;
    }

    public void setBscond(String bscond) {
        this.bscond = bscond;
    }

    public String getCotype() {
        return cotype;
    }

    public void setCotype(String cotype) {
        this.cotype = cotype;
    }

    public String getBstype() {
        return bstype;
    }

    public void setBstype(String bstype) {
        this.bstype = bstype;
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

    public String getCallname() {
        return callname;
    }

    public void setCallname(String callname) {
        this.callname = callname;
    }

    public String getSitesize() {
        return sitesize;
    }

    public void setSitesize(String sitesize) {
        this.sitesize = sitesize;
    }

    public String getPrsdname() {
        return prsdname;
    }

    public void setPrsdname(String prsdname) {
        this.prsdname = prsdname;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getBsno() {
        return bsno;
    }

    public void setBsno(String bsno) {
        this.bsno = bsno;
    }
}
