package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MainDaoImpl implements MainDao {

    @Autowired
    private SqlSession Session;

    // 고객 응대율
    @Override
    public int responseRate(Map<String, Object> param) {
        int responseRate ;

        try {
            responseRate = Session.selectOne("main.responseRate", param);
        } catch (NullPointerException e) {
            responseRate = 0;
        }
        return responseRate;
    }


    // 불만율
    @Override
    public int complainRate(Map<String, Object> param) {
        int complainRate ;

        try {
            complainRate = Session.selectOne("main.complainRate", param);
        } catch (NullPointerException e) {
                complainRate = 0;
        }
        return complainRate;
    }



    // 불만율 - 전월 대비  비율
    @Override
    public int  beforemonthrate  (Map<String, Object> param) {

        return Session.selectOne("main.beforemonthrate", param);

    }

    // 응대율 - 전일 대비  비율
    @Override
    public int beforedayrate(Map<String, Object> param) {

        return Session.selectOne("main.beforedayrate", param);

    }

    // 상담 완료건
    @Override
    public List<Map<String, Object>> endCnt(Map<String, Object> param) {

        return Session.selectList("main.endCnt", param);

    }


    // 상담 미완료건
    @Override
    public List<Map<String, Object>> unendCnt(Map<String, Object> param) {

        return Session.selectList("main.unendCnt", param);

    }



    //  상담 유형
    @Override
    public List<Map<String, Object>> receptType(Map<String, Object> param) {

        return Session.selectList("main.repchart", param);

    }


    // 상담유형 차트
    @Override
    public Map<String, Object> repchart(Map<String, Object> param) {

        return Session.selectOne("main.repchart", param);

    }

    // 접수 제품 년도별
    @Override
    public List<Map<String, Object>> productYear(Map<String, Object> param) {

        return Session.selectList("main.productYear", param);

    }

    // 접수 제품 월별
    @Override
    public List<Map<String, Object>> prodMonth(Map<String, Object> param) {

        return Session.selectList("main.prodMonth", param);

    }


    // 처리현황
    @Override
    public List<Map<String, Object>> processStatus(Map<String, Object> param) {

        return Session.selectList("main.processStatus", param);

    }




    // 콜센터 - 인입현황 (접수유형) 일일
    @Override
    public  Map<String, Object> intypechart(Map<String, Object> param) {

        return Session.selectOne("main.intypechart", param);

    }

    // 콜센터 - 상담 제품 일일
    @Override
    public Map<String, Object> prodDay(Map<String, Object> param) {

        return Session.selectOne("main.prodDay", param);

    }

    // 콜센터 - 처리현황 일일
    @Override
    public Map<String, Object>processDay(Map<String, Object> param) {

        return Session.selectOne("main.processDay", param);

    }



}
