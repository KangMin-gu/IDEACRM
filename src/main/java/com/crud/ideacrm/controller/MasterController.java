package com.crud.ideacrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MasterController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView joinUserChk(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/joinuser/joinUserChk");
        return mView;
    }

}
