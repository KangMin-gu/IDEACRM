package com.crud.ideacrm.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;


public class CodeDto implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int codeno;
	private String codegrp;
	private String codename;
	private String codeval;
	private int uppercodegrp;
	private int siteid;
	private String regdate;
	private int reguser;
	private String edtdate;
	private int edtuser;
	private int isdelete;
	
	public CodeDto() {}

	public CodeDto(int codeno, String codegrp, String codename, String codeval, int uppercodegrp, int siteid,
			String regdate, int reguser, String edtdate, int edtuser, int isdelete) {
		super();
		this.codeno = codeno;
		this.codegrp = codegrp;
		this.codename = codename;
		this.codeval = codeval;
		this.uppercodegrp = uppercodegrp;
		this.siteid = siteid;
		this.regdate = regdate;
		this.reguser = reguser;
		this.edtdate = edtdate;
		this.edtuser = edtuser;
		this.isdelete = isdelete;
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

	public int getUppercodegrp() {
		return uppercodegrp;
	}

	public void setUppercodegrp(int uppercodegrp) {
		this.uppercodegrp = uppercodegrp;
	}

	public int getSiteid() {
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
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

	
}
