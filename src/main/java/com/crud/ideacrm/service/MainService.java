
package com.crud.ideacrm.service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface MainService {

    // 고객 응대율
    public int responseRate (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 응대율 - 전일  대비  상승
    public int  beforedayrate (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 불만율
    public int complainRate (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 불만율 - 전월  대비 하락 
    public int beforemonthrate (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


    // 상담 완료건
    public List<Map<String,Object>> endCnt(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 상담 미완료건
    public List<Map<String,Object>> unendCnt(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


    // 접수유형
    public List<Map<String,Object>> receptType(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 접수유형 차트 챁
    public Map<String,Object> repchart (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


    // 접수 제품 년도별
    public List<Map<String,Object>> productYear(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 접수 제품 월별
    public List<Map<String,Object>> prodMonth(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


    // 처리현황
    public List<Map<String,Object>> processStatus(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    // 콜센터 - 인입현황 (접수유형) 일일
    public  Map<String, Object> intypechart(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


    // 콜센터 - 상담제품 일일
    public Map<String, Object> prodDay  (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


    // 콜센터 - 처리현황 일일
    public  Map<String,Object> processDay  (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;





}
