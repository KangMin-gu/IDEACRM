package com.crud.ideacrm.dto;

public class CustDenyDto {
    private int	denyno;	//거부번호
    private int	custno;	//고객번호
    private int	denymailnomal;	//메일일반수신거부
    private int	denymailsurvey;	//메일설문수신거부
    private int	denymailad;	//메일광고수신거부
    private int	denymailnews;	//메일뉴스수신거부
    private int	denymailseminar;	//메일세미나수신거부
    private int	denysmsnomal;	//일반SMS수신거부
    private int	denysmssurvey;	//설문SMS수신거부
    private int	denysmsseminar;	//세미나SMS수신거부
    private int	denysmsad;	//광고SMS수신거부
    private int	denydmnomal;	//DM일반수신거부(일반)
    private int	denydmsurvey;	//DM설문수신거부(만족도)
    private int	denydmnews;	//DM뉴스수신거부(홍보)
    private int	denydmseminar;	//DM세미나수신거부(세미나)
    private int	denydmad;	//광고DM거부
    private int	denytelnews;	//뉴스TEL거부
    private int	denytelseminar;	//세미나TEL거부
    private int	denytelad;	//광고TEL거부
    private int	denytelsurvey;	//설문TEL거부
    private int	denyfax;	//FAX거부
    private int	denyvisit;	//방문거부
    private String	regdate;	//등록일
    private int	reguser;	//등록자
    private String	editdate;	//수정일
    private int	edituser;	//수정자
    private int	isdelete;	//삭제여부

    public CustDenyDto(){}
    public CustDenyDto(int denyno, int custno, int denymailnomal, int denymailsurvey, int denymailad, int denymailnews, int denymailseminar, int denysmsnomal, int denysmssurvey, int denysmsseminar, int denysmsad, int denydmnomal, int denydmsurvey, int denydmnews, int denydmseminar, int denydmad, int denytelnews, int denytelseminar, int denytelad, int denytelsurvey, int denyfax, int denyvisit, String regdate, int reguser, String editdate, int edituser, int isdelete) {
        this.denyno = denyno;
        this.custno = custno;
        this.denymailnomal = denymailnomal;
        this.denymailsurvey = denymailsurvey;
        this.denymailad = denymailad;
        this.denymailnews = denymailnews;
        this.denymailseminar = denymailseminar;
        this.denysmsnomal = denysmsnomal;
        this.denysmssurvey = denysmssurvey;
        this.denysmsseminar = denysmsseminar;
        this.denysmsad = denysmsad;
        this.denydmnomal = denydmnomal;
        this.denydmsurvey = denydmsurvey;
        this.denydmnews = denydmnews;
        this.denydmseminar = denydmseminar;
        this.denydmad = denydmad;
        this.denytelnews = denytelnews;
        this.denytelseminar = denytelseminar;
        this.denytelad = denytelad;
        this.denytelsurvey = denytelsurvey;
        this.denyfax = denyfax;
        this.denyvisit = denyvisit;
        this.regdate = regdate;
        this.reguser = reguser;
        this.editdate = editdate;
        this.edituser = edituser;
        this.isdelete = isdelete;
    }

    public int getDenyno() {
        return denyno;
    }

    public void setDenyno(int denyno) {
        this.denyno = denyno;
    }

    public int getCustno() {
        return custno;
    }

    public void setCustno(int custno) {
        this.custno = custno;
    }

    public int getDenymailnomal() {
        return denymailnomal;
    }

    public void setDenymailnomal(int denymailnomal) {
        this.denymailnomal = denymailnomal;
    }

    public int getDenymailsurvey() {
        return denymailsurvey;
    }

    public void setDenymailsurvey(int denymailsurvey) {
        this.denymailsurvey = denymailsurvey;
    }

    public int getDenymailad() {
        return denymailad;
    }

    public void setDenymailad(int denymailad) {
        this.denymailad = denymailad;
    }

    public int getDenymailnews() {
        return denymailnews;
    }

    public void setDenymailnews(int denymailnews) {
        this.denymailnews = denymailnews;
    }

    public int getDenymailseminar() {
        return denymailseminar;
    }

    public void setDenymailseminar(int denymailseminar) {
        this.denymailseminar = denymailseminar;
    }

    public int getDenysmsnomal() {
        return denysmsnomal;
    }

    public void setDenysmsnomal(int denysmsnomal) {
        this.denysmsnomal = denysmsnomal;
    }

    public int getDenysmssurvey() {
        return denysmssurvey;
    }

    public void setDenysmssurvey(int denysmssurvey) {
        this.denysmssurvey = denysmssurvey;
    }

    public int getDenysmsseminar() {
        return denysmsseminar;
    }

    public void setDenysmsseminar(int denysmsseminar) {
        this.denysmsseminar = denysmsseminar;
    }

    public int getDenysmsad() {
        return denysmsad;
    }

    public void setDenysmsad(int denysmsad) {
        this.denysmsad = denysmsad;
    }

    public int getDenydmnomal() {
        return denydmnomal;
    }

    public void setDenydmnomal(int denydmnomal) {
        this.denydmnomal = denydmnomal;
    }

    public int getDenydmsurvey() {
        return denydmsurvey;
    }

    public void setDenydmsurvey(int denydmsurvey) {
        this.denydmsurvey = denydmsurvey;
    }

    public int getDenydmnews() {
        return denydmnews;
    }

    public void setDenydmnews(int denydmnews) {
        this.denydmnews = denydmnews;
    }

    public int getDenydmseminar() {
        return denydmseminar;
    }

    public void setDenydmseminar(int denydmseminar) {
        this.denydmseminar = denydmseminar;
    }

    public int getDenydmad() {
        return denydmad;
    }

    public void setDenydmad(int denydmad) {
        this.denydmad = denydmad;
    }

    public int getDenytelnews() {
        return denytelnews;
    }

    public void setDenytelnews(int denytelnews) {
        this.denytelnews = denytelnews;
    }

    public int getDenytelseminar() {
        return denytelseminar;
    }

    public void setDenytelseminar(int denytelseminar) {
        this.denytelseminar = denytelseminar;
    }

    public int getDenytelad() {
        return denytelad;
    }

    public void setDenytelad(int denytelad) {
        this.denytelad = denytelad;
    }

    public int getDenytelsurvey() {
        return denytelsurvey;
    }

    public void setDenytelsurvey(int denytelsurvey) {
        this.denytelsurvey = denytelsurvey;
    }

    public int getDenyfax() {
        return denyfax;
    }

    public void setDenyfax(int denyfax) {
        this.denyfax = denyfax;
    }

    public int getDenyvisit() {
        return denyvisit;
    }

    public void setDenyvisit(int denyvisit) {
        this.denyvisit = denyvisit;
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

    public String getEditdate() {
        return editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    public int getEdituser() {
        return edituser;
    }

    public void setEdituser(int edituser) {
        this.edituser = edituser;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
