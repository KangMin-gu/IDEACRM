package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MasterController {

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView joinUserChk(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/joinuser/joinUserChk");
        return mView;
    }

}
