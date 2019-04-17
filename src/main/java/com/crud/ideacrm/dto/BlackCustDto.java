package com.crud.ideacrm.dto;

public class BlackCustDto  {
    private int	bcustno;	//강성고객번호
    private String	custno;	//고객번호
    private int	blacktype;	//브랙유형
    private String	receiveno;	//
    private String	memo;	//메모
    private String	regdate;	//등록일
    private String	edtdate;	//수정일
    private int	reguser;	//등록자
    private int	edtuser;	//수정자
    private int	isdelete;	//삭제여부
    private int	siteid;	//회원사번호

    public BlackCustDto(){}

    public BlackCustDto(int bcustno, String custno, int blacktype, String receiveno, String memo, String regdate, String edtdate, int reguser, int edtuser, int isdelete, int siteid) {
        this.bcustno = bcustno;
        this.custno = custno;
        this.blacktype = blacktype;
        this.receiveno = receiveno;
        this.memo = memo;
        this.regdate = regdate;
        this.edtdate = edtdate;
        this.reguser = reguser;
        this.edtuser = edtuser;
        this.isdelete = isdelete;
        this.siteid = siteid;
    }

    public int getBcustno() {
        return bcustno;
    }

    public void setBcustno(int bcustno) {
        this.bcustno = bcustno;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public int getBlacktype() {
        return blacktype;
    }

    public void setBlacktype(int blacktype) {
        this.blacktype = blacktype;
    }

    public String getReceiveno() {
        return receiveno;
    }

    public void setReceiveno(String receiveno) {
        this.receiveno = receiveno;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getEdtdate() {
        return edtdate;
    }

    public void setEdtdate(String edtdate) {
        this.edtdate = edtdate;
    }

    public int getReguser() {
        return reguser;
    }

    public void setReguser(int reguser) {
        this.reguser = reguser;
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
}
