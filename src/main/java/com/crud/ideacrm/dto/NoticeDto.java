package com.crud.ideacrm.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class NoticeDto {

    private int ntnum;
    private String title;
    private String content;
    private int reguser;
    private String regdate;
    private int edtuser;
    private String edtdate;
    private int isdelete;
    private String filesearchkey;
    private int siteid;
    private int tag;
    private List<MultipartFile> file; //Spring 에서 파일 업로드 처리하기 위해

    public NoticeDto(){}

    public NoticeDto(int ntnum, String title, String content, int reguser, String regdate, int edtuser, String edtdate, int isdelete, String filesearchkey, int siteid, int tag, List<MultipartFile> file) {
        this.ntnum = ntnum;
        this.title = title;
        this.content = content;
        this.reguser = reguser;
        this.regdate = regdate;
        this.edtuser = edtuser;
        this.edtdate = edtdate;
        this.isdelete = isdelete;
        this.filesearchkey = filesearchkey;
        this.siteid = siteid;
        this.tag = tag;
        this.file = file;
    }

    public int getNtnum() {
        return ntnum;
    }

    public void setNtnum(int ntnum) {
        this.ntnum = ntnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReguser() {
        return reguser;
    }

    public void setReguser(int reguser) {
        this.reguser = reguser;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getEdtuser() {
        return edtuser;
    }

    public void setEdtuser(int edtuser) {
        this.edtuser = edtuser;
    }

    public String getEdtdate() {
        return edtdate;
    }

    public void setEdtdate(String edtdate) {
        this.edtdate = edtdate;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getFilesearchkey() {
        return filesearchkey;
    }

    public void setFilesearchkey(String filesearchkey) {
        this.filesearchkey = filesearchkey;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public List<MultipartFile> getFile() {
        return file;
    }

    public void setFile(List<MultipartFile> file) {
        this.file = file;
    }
}
