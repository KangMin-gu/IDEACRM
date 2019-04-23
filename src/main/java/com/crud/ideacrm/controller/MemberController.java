package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/user/pwdreset", method = RequestMethod.GET)
    @ResponseBody
    public void authuserPwdReset(HttpServletRequest request){
        memberService.userPwdReset(request);
    }




}
