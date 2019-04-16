package com.crud.ideacrm.dto;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.crud.ideacrm.crud.util.CodecUtil;
import org.springframework.web.multipart.MultipartFile;

public class RewardDto {

    private int rewardno;
    private String serviceno;
    private String visitdate;
    private int visitapm;
    private String visithour;
    private String visitminute;
    private int rewardtype;
    private int causecode;
    private int delaytype;
    private String rewarddesc;
    private String delaydesc;
    private String filesearchkey;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;
    private int siteid;
    private List<MultipartFile> rewardfile; //Spring 에서 파일 업로드 처리하기 위해
    private String visitaddr1;
    private String visitaddr2;
    private String visitaddr3;
    private int owner;

    public RewardDto() {}

    public void setEncodingRewardDto() throws UnsupportedEncodingException, GeneralSecurityException {
        CodecUtil commonUtil = new CodecUtil();
        if(this.visitaddr1 != null && this.visitaddr1 != ""){ this.visitaddr1 = commonUtil.encoding(this.visitaddr1);}
        if(this.visitaddr2 != null && this.visitaddr2 != ""){ this.visitaddr2 = commonUtil.encoding(this.visitaddr2);}
        if(this.visitaddr3 != null && this.visitaddr3 != ""){ this.visitaddr3 = commonUtil.encoding(this.visitaddr3);}
    }

    public RewardDto(int rewardno, String serviceno, String visitdate, int visitapm, String visithour, String visitminute, int rewardtype, int causecode, int delaytype, String rewarddesc, String delaydesc, String filesearchkey, String regdate, int reguser, String edtdate, int edtuser, int siteid, List<MultipartFile> rewardfile, String visitaddr1, String visitaddr2, String visitaddr3, int owner) {
        this.rewardno = rewardno;
        this.serviceno = serviceno;
        this.visitdate = visitdate;
        this.visitapm = visitapm;
        this.visithour = visithour;
        this.visitminute = visitminute;
        this.rewardtype = rewardtype;
        this.causecode = causecode;
        this.delaytype = delaytype;
        this.rewarddesc = rewarddesc;
        this.delaydesc = delaydesc;
        this.filesearchkey = filesearchkey;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.siteid = siteid;
        this.rewardfile = rewardfile;
        this.visitaddr1 = visitaddr1;
        this.visitaddr2 = visitaddr2;
        this.visitaddr3 = visitaddr3;
        this.owner = owner;
    }

    public int getRewardno() {
        return rewardno;
    }

    public void setRewardno(int rewardno) {
        this.rewardno = rewardno;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public String getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(String visitdate) {
        this.visitdate = visitdate;
    }

    public int getVisitapm() {
        return visitapm;
    }

    public void setVisitapm(int visitapm) {
        this.visitapm = visitapm;
    }

    public String getVisithour() {
        return visithour;
    }

    public void setVisithour(String visithour) {
        this.visithour = visithour;
    }

    public String getVisitminute() {
        return visitminute;
    }

    public void setVisitminute(String visitminute) {
        this.visitminute = visitminute;
    }

    public int getRewardtype() {
        return rewardtype;
    }

    public void setRewardtype(int rewardtype) {
        this.rewardtype = rewardtype;
    }

    public int getCausecode() {
        return causecode;
    }

    public void setCausecode(int causecode) {
        this.causecode = causecode;
    }

    public int getDelaytype() {
        return delaytype;
    }

    public void setDelaytype(int delaytype) {
        this.delaytype = delaytype;
    }

    public String getRewarddesc() {
        return rewarddesc;
    }

    public void setRewarddesc(String rewarddesc) {
        this.rewarddesc = rewarddesc;
    }

    public String getDelaydesc() {
        return delaydesc;
    }

    public void setDelaydesc(String delaydesc) {
        this.delaydesc = delaydesc;
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

    public List<MultipartFile> getRewardfile() {
        return rewardfile;
    }

    public void setRewardfile(List<MultipartFile> rewardfile) {
        this.rewardfile = rewardfile;
    }

    public String getVisitaddr1() {
        return visitaddr1;
    }

    public void setVisitaddr1(String visitaddr1) {
        this.visitaddr1 = visitaddr1;
    }

    public String getVisitaddr2() {
        return visitaddr2;
    }

    public void setVisitaddr2(String visitaddr2) {
        this.visitaddr2 = visitaddr2;
    }

    public String getVisitaddr3() {
        return visitaddr3;
    }

    public void setVisitaddr3(String visitaddr3) {
        this.visitaddr3 = visitaddr3;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}



