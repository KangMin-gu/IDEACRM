package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormatController {

    @RequestMapping(value = "/company/format", method = RequestMethod.GET)
    public ModelAndView formatList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/format/formatList");
        return mView;
    }

    @RequestMapping(value = "/company/format/1", method = RequestMethod.GET)
    public ModelAndView formatDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/format/formatDetail");
        return mView;
    }

    @RequestMapping(value = "/company/formatform", method = RequestMethod.GET)
    public ModelAndView formatInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/format/formatInsert");
        return mView;
    }

}
