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

    @RequestMapping(value = "/user/pwdreset", method = RequestMethod.GET)
    @ResponseBody
    public void authuserPwdReset(HttpServletRequest request){
        memberService.userPwdReset(request);
    }

    @RequestMapping(value="/user/idcheck/{userId}",method=RequestMethod.GET)
    @ResponseBody
    public int authUserIdCheck(HttpServletRequest request,@PathVariable String userId){

        int cnt = memberService.memberIdCheck(request,userId);

        return cnt;
    }




}
