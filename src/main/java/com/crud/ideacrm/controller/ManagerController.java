package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ManagerController {

    @RequestMapping(value = "/company/notice", method = RequestMethod.GET)
    public ModelAndView siteNoticeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/notice/noticeList");
        return mView;
    }

    @RequestMapping(value = "/company/notice/1", method = RequestMethod.GET)
    public ModelAndView siteNoticeDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/notice/noticeDetail");
        return mView;
    }

    @RequestMapping(value = "/company/noticeform", method = RequestMethod.GET)
    public ModelAndView siteNoticeInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/notice/noticeInsert");
        return mView;
    }
}
