package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InsideNoticeController {

    @RequestMapping(value = "/inbox", method = RequestMethod.GET)
    public ModelAndView inboxList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/inBox");
        return mView;
    }

    @RequestMapping(value = "/outbox", method = RequestMethod.GET)
    public ModelAndView outboxList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/outBox");
        return mView;
    }

    @RequestMapping(value = "/trashbox", method = RequestMethod.GET)
    public ModelAndView trashboxList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/trashBox");
        return mView;
    }

    @RequestMapping(value = "/compose", method = RequestMethod.GET)
    public ModelAndView sendForm(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/sendForm");
        return mView;
    }

    @RequestMapping(value = "/inbox/1", method = RequestMethod.GET)
    public ModelAndView boxDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/boxDetail");
        return mView;
    }

}
