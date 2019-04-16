package com.crud.ideacrm.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ServiceDto {

    private String serviceno;
    private String servicename;
    private String servicedesc;
    private int serviceowner;
    private String receptiondate;
    private String custno;
    private int clino;
    private int servicestep;
    private int owner;
    private int siteid;
    private int servicetype;
    private int servicecode1;
    private int servicecode2;
    private int servicechannel;
    private String filesearchkey;
    private String regdate;
    private int reguser;
    private String edtdate;
    private int edtuser;
    private int isdelete;
    private String memo;
    private int complete;
    private List<MultipartFile> servicefile; //Spring 에서 파일 업로드 처리하기 위해
    private String reqno;

    public ServiceDto() {}

    public ServiceDto(String serviceno, String servicename, String servicedesc, int serviceowner, String receptiondate,
                      String custno, int clino, int servicestep, int owner, int siteid, int servicetype, int servicecode1,
                      int servicecode2, int servicechannel, String filesearchkey, String regdate, int reguser, String edtdate,
                      int edtuser, int isdelete, String memo, int complete, List<MultipartFile> servicefile, String reqno) {
        super();
        this.serviceno = serviceno;
        this.servicename = servicename;
        this.servicedesc = servicedesc;
        this.serviceowner = serviceowner;
        this.receptiondate = receptiondate;
        this.custno = custno;
        this.clino = clino;
        this.servicestep = servicestep;
        this.owner = owner;
        this.siteid = siteid;
        this.servicetype = servicetype;
        this.servicecode1 = servicecode1;
        this.servicecode2 = servicecode2;
        this.servicechannel = servicechannel;
        this.filesearchkey = filesearchkey;
        this.regdate = regdate;
        this.reguser = reguser;
        this.edtdate = edtdate;
        this.edtuser = edtuser;
        this.isdelete = isdelete;
        this.memo = memo;
        this.complete = complete;
        this.servicefile = servicefile;
        this.reqno = reqno;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServicedesc() {
        return servicedesc;
    }

    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc;
    }

    public int getServiceowner() {
        return serviceowner;
    }

    public void setServiceowner(int serviceowner) {
        this.serviceowner = serviceowner;
    }

    public String getReceptiondate() {
        return receptiondate;
    }

    public void setReceptiondate(String receptiondate) {
        this.receptiondate = receptiondate;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public int getClino() {
        return clino;
    }

    public void setClino(int clino) {
        this.clino = clino;
    }

    public int getServicestep() {
        return servicestep;
    }

    public void setServicestep(int servicestep) {
        this.servicestep = servicestep;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public int getServicetype() {
        return servicetype;
    }

    public void setServicetype(int servicetype) {
        this.servicetype = servicetype;
    }

    public int getServicecode1() {
        return servicecode1;
    }

    public void setServicecode1(int servicecode1) {
        this.servicecode1 = servicecode1;
    }

    public int getServicecode2() {
        return servicecode2;
    }

    public void setServicecode2(int servicecode2) {
        this.servicecode2 = servicecode2;
    }

    public int getServicechannel() {
        return servicechannel;
    }

    public void setServicechannel(int servicechannel) {
        this.servicechannel = servicechannel;
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

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public List<MultipartFile> getServicefile() {
        return servicefile;
    }

    public void setServicefile(List<MultipartFile> servicefile) {
        this.servicefile = servicefile;
    }

    public String getReqno() {
        return reqno;
    }

    public void setReqno(String reqno) {
        this.reqno = reqno;
    }


}
