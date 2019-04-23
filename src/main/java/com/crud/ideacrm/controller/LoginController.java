package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.UserDto;
import com.crud.ideacrm.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private LoginService login;

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

    //로그인 요청
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public void login(HttpServletResponse response, HttpServletRequest request, @ModelAttribute UserDto urDto) throws UnsupportedEncodingException, GeneralSecurityException {
        login.login(response, request, urDto);
    }

    //로그아웃
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
