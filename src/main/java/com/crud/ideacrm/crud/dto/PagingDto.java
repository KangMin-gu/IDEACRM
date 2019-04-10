package com.crud.ideacrm.crud.dto;

public class PagingDto {

    private int startPageNum; //시작페이지
    private int endPageNum; //끝페이지
    private int pageNum; //페이지숫자
    private int totalPageCount; //총페이지숫자
    private int totalRows; //총로우수

    public PagingDto() {}

    public PagingDto(int startPageNum, int endPageNum, int pageNum, int totalPageCount, int totalRows) {
        this.startPageNum = startPageNum;
        this.endPageNum = endPageNum;
        this.pageNum = pageNum;
        this.totalPageCount = totalPageCount;
        this.totalRows = totalRows;
    }

    public int getStartPageNum() {
        return startPageNum;
    }

    public void setStartPageNum(int startPageNum) {
        this.startPageNum = startPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
}
