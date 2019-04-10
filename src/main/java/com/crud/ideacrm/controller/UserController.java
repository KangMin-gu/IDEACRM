package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    //고객사 회원목록
    @RequestMapping(value = "/company/user", method = RequestMethod.GET)
    public ModelAndView companyUser(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/member/memberList");
        return mView;
    }

    //회원가입폼호출
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public ModelAndView sign(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/member/memberInsert");
        return mView;
    }

    //회원상세정보
    @RequestMapping(value = "/company/user/1", method = RequestMethod.GET)
    public ModelAndView userDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/member/memberDetail");
        return mView;
    }


}
