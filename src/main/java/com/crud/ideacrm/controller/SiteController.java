package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SiteController {

    //회원사 회사정보
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ModelAndView companyInfo(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/site/siteDetail");
        return mView;
    }

    //회원사목록
    @RequestMapping(value="/site", method= RequestMethod.GET)
    public ModelAndView siteList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/site/siteList");
        return mView;
    }

    //master 회원사 상세정보
    @RequestMapping(value="/sitedetail", method= RequestMethod.GET)
    public ModelAndView siteDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/site/siteDetail");
        return mView;
    }

    //회원사 등록
    @RequestMapping(value="/siteinsert", method= RequestMethod.GET)
    public ModelAndView siteInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/site/siteInsert");
        return mView;
    }


}
