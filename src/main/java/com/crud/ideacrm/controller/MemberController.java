package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/company/user/{userNo}", method = RequestMethod.GET)
    public ModelAndView authuserInfo(HttpServletRequest request, @PathVariable int userNo){
        ModelAndView mView = memberService.userInfo(request, userNo);
        mView.setViewName("page/membership/member/memberDetail");
        return mView;
    }

    @RequestMapping(value = "/user/pwdreset", method = RequestMethod.GET)
    @ResponseBody
    public void authuserPwdReset(HttpServletRequest request){
        memberService.userPwdReset(request);
    }




}
