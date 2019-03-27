package com.crud.ideacrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

  //  @Autowired
   // private LoginService login;

    //로그인폼요청
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView loginForm(HttpServletRequest request) {

        String url=request.getParameter("url");

        if(url==null){
            url=request.getContextPath()+"/";
        }

        ModelAndView mView = new ModelAndView();
        mView.addObject("url", url);
        mView.setViewName("page/membership/login");
        return mView;
    }
}
