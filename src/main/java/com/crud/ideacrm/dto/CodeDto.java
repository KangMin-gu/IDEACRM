package com.crud.ideacrm.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;


public class CodeDto implements Serializable{

	private int	codeno;	//코드번호
	private String	codegrp;	//코드그룹
	private String	codename;	//코드명
	private String	codeval;	//코드값
	private String	uppercodegrp;	//상위그룹코드
	private String	regdate;	//등록일
	private int	reguser;	//등록자
	private String	edtdate;	//수정일
	private int	edtuser;	//수정자
	private int	isdelete;	//삭제여부
	private int	siteid;	//회원사번호
	private int	commonflag;	//공통코드여부 0=공통, 1=회원사별
	private int	usingmenu;	//코드사용 메뉴 0=모든메뉴,1=고객,2=영업,3=서비스,4=캠페인

	public CodeDto(){}

	public CodeDto(int codeno, String codegrp, String codename, String codeval, String uppercodegrp, String regdate, int reguser, String edtdate, int edtuser, int isdelete, int siteid, int commonflag, int usingmenu) {
		this.codeno = codeno;
		this.codegrp = codegrp;
		this.codename = codename;
		this.codeval = codeval;
		this.uppercodegrp = uppercodegrp;
		this.regdate = regdate;
		this.reguser = reguser;
		this.edtdate = edtdate;
		this.edtuser = edtuser;
		this.isdelete = isdelete;
		this.siteid = siteid;
		this.commonflag = commonflag;
		this.usingmenu = usingmenu;
	}

	public int getCodeno() {
		return codeno;
	}

	public void setCodeno(int codeno) {
		this.codeno = codeno;
	}

	public String getCodegrp() {
		return codegrp;
	}

	public void setCodegrp(String codegrp) {
		this.codegrp = codegrp;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getCodeval() {
		return codeval;
	}

	public void setCodeval(String codeval) {
		this.codeval = codeval;
	}

	public String getUppercodegrp() {
		return uppercodegrp;
	}

	public void setUppercodegrp(String uppercodegrp) {
		this.uppercodegrp = uppercodegrp;
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

	public int getSiteid() {
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

	public int getCommonflag() {
		return commonflag;
	}

	public void setCommonflag(int commonflag) {
		this.commonflag = commonflag;
	}

	public int getUsingmenu() {
		return usingmenu;
	}

	public void setUsingmenu(int usingmenu) {
		this.usingmenu = usingmenu;
	}
}
