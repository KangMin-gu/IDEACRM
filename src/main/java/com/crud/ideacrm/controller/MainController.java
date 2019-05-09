package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Map;


@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MainService mainService;

    //메인
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView authmain(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        // 고객 응대율
        mView.addObject("responseRate", mainService.responseRate(request));

        // 응대율 - 전월 대비  상승
        mView.addObject("beforemonthrate", mainService.beforemonthrate(request));

        // 불만율
        mView.addObject("complainRate", mainService.complainRate(request));

        // 불만율 - 전일 대비  하락
        mView.addObject("beforedayrate", mainService.beforedayrate(request));




        // 상담 완료건
        mView.addObject("endCnt", mainService.endCnt(request));

        // 상담 미완료건
        mView.addObject("unendCnt", mainService.unendCnt(request));


        // 접수유형
        mView.addObject("receptType", mainService.receptType(request));

        // 접수 제품 년도별
        mView.addObject("productYear", mainService.productYear(request));

        // 접수 제품 월별
        mView.addObject("productType", mainService.prodMonth(request));

        // 제품 판매량 top 5
        mView.addObject("productTop", mainService.prodMonth(request));



        // 1 콜센터 - 접수 유형 일일
        mView.addObject("intypechart", mainService.intypechart(request));

        // 2 콜센터 - 상담제품 일일
        mView.addObject("prodDay", mainService.prodDay(request));

        // 3  콜센터 - 상담처리현황
        mView.addObject("processDay", mainService.processDay(request));


        mView.setViewName("page/index");
        return mView;

    }



    // 상담유형 차트
    @RequestMapping(value = "/main/chart/recp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> repchart(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object>  chart = mainService.repchart(request);
        return chart;

    }

    // 1 콜센터 인입현황 차트
    @RequestMapping(value = "/main/chart/intype", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> intypechart (HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object>  chart = mainService.intypechart(request);
        return chart;

    }

    // 2 콜센터 - 접수 제품 일일
   @RequestMapping(value = "/main/chart/produDay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> prodDay(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object>  chart = mainService.prodDay(request);
        return chart;

    }


    // 3 콜센터 - 상담처리현황
   @RequestMapping(value = "/main/chart/proc", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> processDay(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object>  chart = mainService.processDay(request);
        return chart;

    }



};