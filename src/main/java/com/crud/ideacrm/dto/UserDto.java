package com.crud.ideacrm.dto;

import com.crud.ideacrm.crud.util.CodecUtil;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class UserDto {

    private String userno; //회원번호 PK
    private int siteid; //회원소속 회원사
    private String userid; //회원 ID
    private String username; //회원 이름
    private String userpassword; //회원비밀번호
    private String userdesc; //회원 설명
    private String email;
    private int deptid; //부서번호
    private int chkauth; //권한체크 10 / 20 / 30
    private String enterdate; //가입일자
    private String userlang; //언어
    private String mobile1;
    private String mobile2;
    private String mobile3;
    private String telno1;
    private String telno2;
    private String telno3;
    private String userduty; //직책
    private int chkrole;
    private String ctiid; //CTI ID
    private String ctipass; //CTI PASSWORD
    private String ctitelno; // CTI 전화번호
    private String pwdchangedate; //비밀번호 변경일시
    private int isdelete; //사용여부 0 / 1
    private String regdate; //등록일시
    private int reguser; //등록자
    private String edtdate; //수정일시
    private int edtuser; //수정자
    private String code;
    private int masteryn;
    private String mobile;



    public UserDto () {}

    public void setEncodingUserDto() throws UnsupportedEncodingException, GeneralSecurityException {
        CodecUtil commonUtil = new CodecUtil();
        if(this.mobile1 != null && this.mobile1 != ""){ this.mobile1 = commonUtil.encoding(this.mobile1);}
        if(this.mobile2 != null && this.mobile2 != ""){ this.mobile2 = commonUtil.encoding(this.mobile2);}
        if(this.mobile3 != null && this.mobile3 != ""){ this.mobile3 = commonUtil.encoding(this.mobile3);}
        if(this.telno1 != null && this.telno1 != ""){ this.telno1 = commonUtil.encoding(this.telno1);}
        if(this.telno2 != null && this.telno2 != ""){ this.telno2 = commonUtil.encoding(this.telno2);}
        if(this.telno3 != null && this.telno3 != ""){ this.telno3 = commonUtil.encoding(this.telno3);}
        if(this.email != null && this.email != ""){ this.email = commonUtil.encoding(this.email);}
    }

    public UserDto(String userno, int siteid, String userid, String username, String userpassword, String userdesc, String email, int deptid, int chkauth, String enterdate, String userlang, String mobile1, String mobile2, String mobile3, String telno1, String telno2, String telno3, String userduty, int chkrole, String ctiid, String ctipass, String ctitelno, String pwdchangedate, int isdelete, String regdate, int reguser, String edtdate, int edtuser, String code, int masteryn, String mobile) {
        this.userno = userno;
        this.siteid = siteid;
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
        this.userdesc = userdesc;
        this.email = email;
        this.deptid = deptid;
        this.chkauth = chkauth;
        this.enterdate = enterdate;
        this.userlang = userlang;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.mobile3 = mobile3;
        this.telno1 = telno1;
        this.telno2 = telno2;
        this.telno3 = telno3;
        this.userduty = userduty;
        this.chkrole = chkrole;
        this.ctiid = ctiid;
        this.ctipass = ctipass;
        this.ctitelno = ctitelno;
        this.pwdchangedate = pwdchangedate;
        this.isdelete = isdelete;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.code = code;
        this.masteryn = masteryn;
        this.mobile = mobile;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getChkauth() {
        return chkauth;
    }

    public void setChkauth(int chkauth) {
        this.chkauth = chkauth;
    }

    public String getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(String enterdate) {
        this.enterdate = enterdate;
    }

    public String getUserlang() {
        return userlang;
    }

    public void setUserlang(String userlang) {
        this.userlang = userlang;
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

    public String getUserduty() {
        return userduty;
    }

    public void setUserduty(String userduty) {
        this.userduty = userduty;
    }

    public int getChkrole() {
        return chkrole;
    }

    public void setChkrole(int chkrole) {
        this.chkrole = chkrole;
    }

    public String getCtiid() {
        return ctiid;
    }

    public void setCtiid(String ctiid) {
        this.ctiid = ctiid;
    }

    public String getCtipass() {
        return ctipass;
    }

    public void setCtipass(String ctipass) {
        this.ctipass = ctipass;
    }

    public String getCtitelno() {
        return ctitelno;
    }

    public void setCtitelno(String ctitelno) {
        this.ctitelno = ctitelno;
    }

    public String getPwdchangedate() {
        return pwdchangedate;
    }

    public void setPwdchangedate(String pwdchangedate) {
        this.pwdchangedate = pwdchangedate;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMasteryn() {
        return masteryn;
    }

    public void setMasteryn(int masteryn) {
        this.masteryn = masteryn;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
