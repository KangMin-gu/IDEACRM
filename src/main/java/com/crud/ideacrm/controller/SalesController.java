package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SalesController {

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public ModelAndView salesList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/salesList");
        return mView;
    }


    @RequestMapping(value = "/salesdetail", method = RequestMethod.GET)
    public ModelAndView salesDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/salesDetail");
        return mView;
    }

    @RequestMapping(value = "/salesinsert", method = RequestMethod.GET)
    public ModelAndView salesInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/salesInsert");
        return mView;
    }

    @RequestMapping(value = "/sales/calendar", method = RequestMethod.GET)
    public ModelAndView salesCalendar(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/calendar/salesCalendar");
        return mView;
    }
}
