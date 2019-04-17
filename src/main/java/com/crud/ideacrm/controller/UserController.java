package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.UserDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Controller
public class UserController {

    @Autowired
    private CodeService codeService;

    @Autowired
    private UserService userService;

    private final static int USINGMENU = 0;

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
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/membership/member/memberInsert");
        return mView;
    }

    @RequestMapping(value="/company/user/input",method=RequestMethod.POST)
    public ModelAndView companyUserInsertSet(HttpServletRequest request, UserDto userDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String userNo = userService.userInsert(request,userDto);
        mView.setViewName("redirect:/company/user/"+userNo);

        return mView;
    }


    //회원상세정보
    @RequestMapping(value = "/company/user/{userNo}", method = RequestMethod.GET)
    public ModelAndView userDetail(HttpServletRequest request, @PathVariable String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addObject("userInfo",userService.userDetail(request,userNo));
        mView.setViewName("page/membership/member/memberDetail");
        return mView;
    }


}
