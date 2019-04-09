package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MasterController {

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ModelAndView siteanNoticeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/allNotice/anNoticeList");
        return mView;
    }

    @RequestMapping(value = "/notice/1", method = RequestMethod.GET)
    public ModelAndView siteanNoticeDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/allNotice/anNoticeDetail");
        return mView;
    }

    @RequestMapping(value = "/noticeform", method = RequestMethod.GET)
    public ModelAndView siteanNoticeInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/allNotice/anNoticeInsert");
        return mView;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView joinUserChk(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/joinuser/joinUserChk");
        return mView;
    }

}
