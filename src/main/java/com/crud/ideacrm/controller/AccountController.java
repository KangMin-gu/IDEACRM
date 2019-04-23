package com.crud.ideacrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView accountList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/account/accountList");
        return mView;
    }

    @RequestMapping(value = "/accountdetail", method = RequestMethod.GET)
    public ModelAndView accountDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/account/accountDetail");
        return mView;
    }

    @RequestMapping(value = "/accountinsert", method = RequestMethod.GET)
    public ModelAndView accountInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/sales/account/accountInsert");
        return mView;
    }

}
