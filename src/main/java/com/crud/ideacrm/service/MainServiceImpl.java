package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.MainDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MainDao mainDao;

    @Autowired
    private ParameterUtil paramUtil;


    // 고객 응대율
    @Override
    public int responseRate(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        int responseRate = mainDao.responseRate(param);

        return responseRate;
    }


    // 응대율 - 전일대비  상승
    @Override
    public int beforemonthrate (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String, Object> param = paramUtil.searchParam(request);
        int beforemonthrate = mainDao.beforemonthrate(param);

        return beforemonthrate;
    }


    // 불만율
    @Override
    public int complainRate(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        int complainRate = mainDao.complainRate(param);

        return complainRate;
    }


    // 불만율 - 전월대비  하락
    @Override
    public int beforedayrate (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String, Object> param = paramUtil.searchParam(request);
        int beforedayrate = mainDao.beforedayrate(param);

        return beforedayrate;

    }

    // 상담 완료건
    @Override
    public List<Map<String, Object>> endCnt(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        List<Map<String, Object>> endCnt = mainDao.endCnt(param);

        return endCnt;

    }


    // 상담 미완료건
    @Override
    public List<Map<String, Object>> unendCnt(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        List<Map<String, Object>> unendCnt = mainDao.unendCnt(param);

        return unendCnt;

    }


    // 접수 유형
    @Override
    public List<Map<String, Object>> receptType(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        List<Map<String, Object>> receptType = mainDao.receptType(param);

        return receptType;
    }


    //  접수유형 차트
    @Override
    public Map<String, Object> repchart(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> param = paramUtil.searchParam(request);
        Map<String, Object> repchart = mainDao.repchart(param);

        return repchart;
    }

    // 접수 제품 년도별
    @Override
    public List<Map<String, Object>> productYear(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        List<Map<String, Object>> productYear = mainDao.productYear(param);

        return productYear;
    }


    // 접수 제품 월별
    @Override
    public List<Map<String, Object>> prodMonth(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        List<Map<String, Object>> prodMonth = mainDao.prodMonth(param);

        return prodMonth;

    }


    // 처리현황
    @Override
    public List<Map<String, Object>> processStatus(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        List<Map<String, Object>> processStatus = mainDao.processStatus(param);

        return processStatus;

    }


    // 콜센터 인입현황
    @Override
    public Map<String, Object> intypechart(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> param = paramUtil.searchParam(request);
        Map<String, Object> intypechart = mainDao.intypechart(param);

        return intypechart;
    }

    // 콜센터 - 상담 제품 일일
    @Override
    public Map<String, Object> prodDay(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        Map<String, Object> prodDay = mainDao.prodDay(param);

        return prodDay;

    }


    // 콜센터 - 처리현황 일일
    @Override
    public Map<String, Object> processDay(HttpServletRequest request) {

        Map<String, Object> param = paramUtil.searchParam(request);
        Map<String, Object> processDay = mainDao.processDay(param);

        return processDay;

    }




}
































