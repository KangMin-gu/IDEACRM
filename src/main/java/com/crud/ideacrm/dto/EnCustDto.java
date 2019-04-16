package com.crud.ideacrm.dto;

import com.crud.ideacrm.crud.util.CodecUtil;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * CustDto의 핸드폰,전화번호,email,주소 필드를 암호화.
 * 기본 생성자가 없으며 new 의 인자값으로 CustDto가 들어온다.
 */
public class EnCustDto extends CustDto implements Serializable {

    private String	custno;	//고객번호
    private int	siteid;	//회원사번호
    private String	custname;	//고객명
    private String	deptname;	//부서명
    private String	duty;	//직급
    private String	mobile1;	//핸드폰01
    private String	mobile2;	//핸드폰02
    private String	mobile3;	//핸드폰03
    private String	email;	//이메일
    private int	sex;	//성별
    private int	custgubun;	//고객구분
    private int	custgrade;	//고객등급
    private int	infoagree;	//정보동의
    private String	birth;	//생일
    private int	married;	//결혼여부
    private String	weddingday;	//결혼기념일
    private int	solar;	//음력양력구분
    private String	job;	//직업
    private String	hobby;	//취미
    private int	ismember;	//멤버여부
    private String	homtel1;	//집전화01
    private String	homtel2;	//집전화02
    private String	homtel3;	//집전화03
    private String	homaddr1;	//집주소01
    private String	homaddr2;	//집주소02
    private String	homaddr3;	//집주소03
    private String	wrkaddr1;	//직장주소01
    private String	wrkaddr2;	//직장주소02
    private String	wrkaddr3;	//직장주소03
    private String	wrktel1;	//직장전화01
    private String	wrktel2;	//직장전화02
    private String	wrktel3;	//직장전화03
    private String	wrkurl;	//직장URL
    private int	owner;	//담당자
    private String	memo;	//메모
    private String	regdate;	//둥록일
    private int	reguser;	//등록자
    private String	editdate;	//수정일
    private int	edituser;	//수정자
    private int	isdelete;	//삭제여부
    private String	wrkfax1;	//직장팩스01
    private String	wrkfax2;	//직장팩스02
    private String	wrkfax3;	//직장팩스03
    private int	mailto;	//수신자메일
    private int	actgrade;	//활동등급
    private int	clino;	//고객사번호
    private int	clicustno;	//클라이언트고객번호
    private String	relcustno;	//고객관계번호

    public EnCustDto(CustDto custDto) throws UnsupportedEncodingException, GeneralSecurityException {
        this.custno = custDto.getCustno();
        this.siteid = custDto.getSiteid();
        this.custname = custDto.getCustname();
        this.deptname = custDto.getDeptname();
        this.duty = custDto.getDuty();
        this.mobile1 = custDto.getMobile1();
        this.mobile2 = custDto.getMobile2();
        this.mobile3 = custDto.getMobile3();
        this.email = custDto.getEmail();
        this.sex = custDto.getSex();
        this.custgubun = custDto.getCustgubun();
        this.custgrade = custDto.getCustgrade();
        this.infoagree = custDto.getInfoagree();
        this.birth = custDto.getBirth();
        this.married = custDto.getMarried();
        this.weddingday = custDto.getWeddingday();
        this.solar = custDto.getSolar();
        this.job = custDto.getJob();
        this.hobby = custDto.getHobby();
        this.ismember = custDto.getIsmember();
        this.homtel1 = custDto.getHomtel1();
        this.homtel2 = custDto.getHomtel2();
        this.homtel3 = custDto.getHomtel3();
        this.homaddr1 = custDto.getHomaddr1();
        this.homaddr2 = custDto.getHomaddr2();
        this.homaddr3 = custDto.getHomaddr3();
        this.wrkaddr1 = custDto.getWrkaddr1();
        this.wrkaddr2 = custDto.getWrkaddr2();
        this.wrkaddr3 = custDto.getWrkaddr3();
        this.wrktel1 = custDto.getWrktel1();
        this.wrktel2 = custDto.getWrktel2();
        this.wrktel3 = custDto.getWrktel3();
        this.wrkurl = custDto.getWrkurl();
        this.owner = custDto.getOwner();
        this.memo = custDto.getMemo();
        this.regdate = custDto.getRegdate();
        this.reguser = custDto.getReguser();
        this.editdate = custDto.getEditdate();
        this.edituser = custDto.getEdituser();
        this.isdelete = custDto.getIsdelete();
        this.wrkfax1 = custDto.getWrkfax1();
        this.wrkfax2 = custDto.getWrkfax2();
        this.wrkfax3 = custDto.getWrkfax3();
        this.mailto = custDto.getMailto();
        this.actgrade = custDto.getActgrade();
        this.clino = custDto.getClino();
        this.clicustno = custDto.getClicustno();
        this.relcustno = custDto.getRelcustno();

        setEncodingCustDto();
    }

    private void setEncodingCustDto() throws UnsupportedEncodingException, GeneralSecurityException {
        CodecUtil commonUtil = new CodecUtil();

        if(this.mobile1 != null && this.mobile1 != ""){ this.mobile1 = commonUtil.encoding(this.mobile1);}
        if(this.mobile2 != null && this.mobile2 != ""){ this.mobile2 = commonUtil.encoding(this.mobile2);}
        if(this.mobile3 != null && this.mobile3 != ""){ this.mobile3 = commonUtil.encoding(this.mobile3);}
        if(this.homtel1 != null && this.homtel1 != ""){ this.homtel1 = commonUtil.encoding(this.homtel1);}
        if(this.homtel2 != null && this.homtel2 != ""){ this.homtel2 = commonUtil.encoding(this.homtel2);}
        if(this.homtel3 != null && this.homtel3 != ""){ this.homtel3 = commonUtil.encoding(this.homtel3);}
        if(this.homaddr1 != null && this.homaddr1 != ""){ this.homaddr1 = commonUtil.encoding(this.homaddr1);}
        if(this.homaddr2 != null && this.homaddr2 != ""){ this.homaddr2 = commonUtil.encoding(this.homaddr2);}
        if(this.homaddr3 != null && this.homaddr3 != ""){ this.homaddr3 = commonUtil.encoding(this.homaddr3);}
        if(this.email != null && this.email != ""){ this.email = commonUtil.encoding(this.email); }
    }

    @Override
    public String getCustno() {
        return custno;
    }

    @Override
    public void setCustno(String custno) {
        this.custno = custno;
    }

    @Override
    public int getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    @Override
    public String getCustname() {
        return custname;
    }

    @Override
    public void setCustname(String custname) {
        this.custname = custname;
    }

    @Override
    public String getDeptname() {
        return deptname;
    }

    @Override
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String getDuty() {
        return duty;
    }

    @Override
    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public String getMobile1() {
        return mobile1;
    }

    @Override
    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    @Override
    public String getMobile2() {
        return mobile2;
    }

    @Override
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    @Override
    public String getMobile3() {
        return mobile3;
    }

    @Override
    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getSex() {
        return sex;
    }

    @Override
    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public int getCustgubun() {
        return custgubun;
    }

    @Override
    public void setCustgubun(int custgubun) {
        this.custgubun = custgubun;
    }

    @Override
    public int getCustgrade() {
        return custgrade;
    }

    @Override
    public void setCustgrade(int custgrade) {
        this.custgrade = custgrade;
    }

    @Override
    public int getInfoagree() {
        return infoagree;
    }

    @Override
    public void setInfoagree(int infoagree) {
        this.infoagree = infoagree;
    }

    @Override
    public String getBirth() {
        return birth;
    }

    @Override
    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public int getMarried() {
        return married;
    }

    @Override
    public void setMarried(int married) {
        this.married = married;
    }

    @Override
    public String getWeddingday() {
        return weddingday;
    }

    @Override
    public void setWeddingday(String weddingday) {
        this.weddingday = weddingday;
    }

    @Override
    public int getSolar() {
        return solar;
    }

    @Override
    public void setSolar(int solar) {
        this.solar = solar;
    }

    @Override
    public String getJob() {
        return job;
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String getHobby() {
        return hobby;
    }

    @Override
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public int getIsmember() {
        return ismember;
    }

    @Override
    public void setIsmember(int ismember) {
        this.ismember = ismember;
    }

    @Override
    public String getHomtel1() {
        return homtel1;
    }

    @Override
    public void setHomtel1(String homtel1) {
        this.homtel1 = homtel1;
    }

    @Override
    public String getHomtel2() {
        return homtel2;
    }

    @Override
    public void setHomtel2(String homtel2) {
        this.homtel2 = homtel2;
    }

    @Override
    public String getHomtel3() {
        return homtel3;
    }

    @Override
    public void setHomtel3(String homtel3) {
        this.homtel3 = homtel3;
    }

    @Override
    public String getHomaddr1() {
        return homaddr1;
    }

    @Override
    public void setHomaddr1(String homaddr1) {
        this.homaddr1 = homaddr1;
    }

    @Override
    public String getHomaddr2() {
        return homaddr2;
    }

    @Override
    public void setHomaddr2(String homaddr2) {
        this.homaddr2 = homaddr2;
    }

    @Override
    public String getHomaddr3() {
        return homaddr3;
    }

    @Override
    public void setHomaddr3(String homaddr3) {
        this.homaddr3 = homaddr3;
    }

    @Override
    public String getWrkaddr1() {
        return wrkaddr1;
    }

    @Override
    public void setWrkaddr1(String wrkaddr1) {
        this.wrkaddr1 = wrkaddr1;
    }

    @Override
    public String getWrkaddr2() {
        return wrkaddr2;
    }

    @Override
    public void setWrkaddr2(String wrkaddr2) {
        this.wrkaddr2 = wrkaddr2;
    }

    @Override
    public String getWrkaddr3() {
        return wrkaddr3;
    }

    @Override
    public void setWrkaddr3(String wrkaddr3) {
        this.wrkaddr3 = wrkaddr3;
    }

    @Override
    public String getWrktel1() {
        return wrktel1;
    }

    @Override
    public void setWrktel1(String wrktel1) {
        this.wrktel1 = wrktel1;
    }

    @Override
    public String getWrktel2() {
        return wrktel2;
    }

    @Override
    public void setWrktel2(String wrktel2) {
        this.wrktel2 = wrktel2;
    }

    @Override
    public String getWrktel3() {
        return wrktel3;
    }

    @Override
    public void setWrktel3(String wrktel3) {
        this.wrktel3 = wrktel3;
    }

    @Override
    public String getWrkurl() {
        return wrkurl;
    }

    @Override
    public void setWrkurl(String wrkurl) {
        this.wrkurl = wrkurl;
    }

    @Override
    public int getOwner() {
        return owner;
    }

    @Override
    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public String getMemo() {
        return memo;
    }

    @Override
    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String getRegdate() {
        return regdate;
    }

    @Override
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public int getReguser() {
        return reguser;
    }

    @Override
    public void setReguser(int reguser) {
        this.reguser = reguser;
    }

    @Override
    public String getEditdate() {
        return editdate;
    }

    @Override
    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    @Override
    public int getEdituser() {
        return edituser;
    }

    @Override
    public void setEdituser(int edituser) {
        this.edituser = edituser;
    }

    @Override
    public int getIsdelete() {
        return isdelete;
    }

    @Override
    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String getWrkfax1() {
        return wrkfax1;
    }

    @Override
    public void setWrkfax1(String wrkfax1) {
        this.wrkfax1 = wrkfax1;
    }

    @Override
    public String getWrkfax2() {
        return wrkfax2;
    }

    @Override
    public void setWrkfax2(String wrkfax2) {
        this.wrkfax2 = wrkfax2;
    }

    @Override
    public String getWrkfax3() {
        return wrkfax3;
    }

    @Override
    public void setWrkfax3(String wrkfax3) {
        this.wrkfax3 = wrkfax3;
    }

    @Override
    public int getMailto() {
        return mailto;
    }

    @Override
    public void setMailto(int mailto) {
        this.mailto = mailto;
    }

    @Override
    public int getActgrade() {
        return actgrade;
    }

    @Override
    public void setActgrade(int actgrade) {
        this.actgrade = actgrade;
    }

    @Override
    public int getClino() {
        return clino;
    }

    @Override
    public void setClino(int clino) {
        this.clino = clino;
    }

    @Override
    public int getClicustno() {
        return clicustno;
    }

    @Override
    public void setClicustno(int clicustno) {
        this.clicustno = clicustno;
    }

    @Override
    public String getRelcustno() {
        return relcustno;
    }

    @Override
    public void setRelcustno(String relcustno) {
        this.relcustno = relcustno;
    }
}