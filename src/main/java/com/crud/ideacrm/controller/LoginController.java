package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    //로그인 페이지
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/login");
        return mView;
    }

}
