package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustController {

    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView custList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/custList");
        return mView;
    }

    @RequestMapping(value = "/custdetail", method = RequestMethod.GET)
    public ModelAndView custDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/custDetail");
        return mView;
    }

    @RequestMapping(value = "/custinsert", method = RequestMethod.GET)
    public ModelAndView custInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/custInsert");
        return mView;
    }

}
