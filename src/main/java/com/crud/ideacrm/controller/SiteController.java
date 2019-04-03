package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SiteController {

    //메인 화면
    @RequestMapping(value="/site", method= RequestMethod.GET)
    public ModelAndView siteList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/master/site/siteList");
        return mView;
    }

    //메인 화면
    @RequestMapping(value="/sitedetail", method= RequestMethod.GET)
    public ModelAndView siteDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/master/site/siteDetail");
        return mView;
    }

    //메인 화면
    @RequestMapping(value="/siteinsert", method= RequestMethod.GET)
    public ModelAndView siteInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/master/site/siteInsert");
        return mView;
    }


}
