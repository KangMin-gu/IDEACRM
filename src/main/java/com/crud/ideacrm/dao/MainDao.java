package com.crud.ideacrm.dao;

// 메인 차트

import java.util.List;
import java.util.Map;

public interface MainDao {

    // 고객 응대율
    public int responseRate(Map<String, Object> map);

    // 응대율 - 전월 대비  비율
    public int beforemonthrate(Map<String, Object> map);

    // 불만율
    public int complainRate(Map<String, Object> map);

    // 불만율 - 전일 대비  비율
    public int beforedayrate(Map<String, Object> map);

    // 상담 완료건
    public List<Map<String, Object>> endCnt(Map<String, Object> map);

    // 상담 미완료건
    public List<Map<String, Object>> unendCnt(Map<String, Object> map);

    //  접수유형
    public List<Map<String, Object>> receptType(Map<String, Object> map);

    // 접수유형 차트
    public Map<String, Object>  repchart(Map<String, Object> param);

    // 접수 제품 년도별
    public List<Map<String, Object>> productYear(Map<String, Object> map);

    // 접수 제품 월별
    public List<Map<String, Object>> prodMonth(Map<String, Object> map);

    // 처리현황
    public List<Map<String, Object>> processStatus(Map<String, Object> param);

    // 콜센터 - 인입현황 (접수유형) 일일
    public Map<String, Object> intypechart(Map<String, Object> param);

    // 콜센터 - 상담제품 일일
    public Map<String, Object> prodDay(Map<String, Object> param);

    // 콜센터 - 처리현황 일일
    public Map<String, Object> processDay(Map<String, Object> param);



}