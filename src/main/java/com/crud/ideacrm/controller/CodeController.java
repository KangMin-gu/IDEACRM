package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CodeController {

    @RequestMapping(value = "/common/code", method = RequestMethod.GET)
    public ModelAndView commonCodeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/code/codeList");
        return mView;
    }

    @RequestMapping(value = "/company/code", method = RequestMethod.GET)
    public ModelAndView codeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/manager/code/codeList");
        return mView;
    }


}
