package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ServiceController {

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView serviceList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceList");
        return mView;
    }


    @RequestMapping(value = "/servicedetail", method = RequestMethod.GET)
    public ModelAndView serviceDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceDetail");
        return mView;
    }

    @RequestMapping(value = "/serviceinsert", method = RequestMethod.GET)
    public ModelAndView serviceInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceInsert");
        return mView;
    }

    @RequestMapping(value = "/service/calendar", method = RequestMethod.GET)
    public ModelAndView serviceCalendar(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/calendar/serviceCalendar");
        return mView;
    }
}
