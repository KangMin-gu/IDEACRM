package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Controller
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/user/pwdreset", method = RequestMethod.GET)
    @ResponseBody
    public void authuserPwdReset(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        memberService.userPwdReset(request);
    }

    @RequestMapping(value="/user/idcheck/{userId}",method=RequestMethod.GET)
    @ResponseBody
    public int authUserIdCheck(HttpServletRequest request,@PathVariable String userId){

        //int cnt = memberService.memberIdCheck(request,userId);
        return 0;
    }

    @RequestMapping(value="/user/idcheck",method=RequestMethod.GET)
    @ResponseBody
    public int authUserIdCheckV(HttpServletRequest request){

        int cnt = memberService.memberIdCheck(request);
        return cnt;
    }

}
