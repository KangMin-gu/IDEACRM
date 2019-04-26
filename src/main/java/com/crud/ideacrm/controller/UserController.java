package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.UserCtiDto;
import com.crud.ideacrm.dto.UserDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.LicenseService;
import com.crud.ideacrm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CodeService codeService;

    @Autowired
    private UserService userService;
    @Autowired
    private LicenseService licenseService;

    private final static int USINGMENU = 0;

    //고객사 회원목록
    @RequestMapping(value = "/company/user", method = RequestMethod.GET)
    public ModelAndView authCompanyUser(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/membership/member/memberList");
        return mView;
    }

    @RequestMapping(value="/company/user",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authCompanyUserList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> companyUserList = userService.userList(request);

        return companyUserList;
    }

    //회원가입폼호출
    @RequestMapping(value = "/company/user/input", method = RequestMethod.GET)
    public ModelAndView authSign(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
            mView.addAllObjects( codeService.getCommonCode(USINGMENU));
            mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
            mView.setViewName("page/membership/member/memberInsert");
        return mView;
    }

    // 회원가입
    @RequestMapping(value="/company/user/input",method=RequestMethod.POST)
    public ModelAndView authCompanyUserInsertSet(HttpServletRequest request, UserDto userDto, UserCtiDto userCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String userNo = userService.userInsert(request,userDto,userCtiDto);
        mView.setViewName("redirect:/company/user/"+userNo);

        return mView;
    }

    //회원상세정보
    @RequestMapping(value = "/company/user/{userNo}", method = RequestMethod.GET)
    public ModelAndView authUserDetail(HttpServletRequest request, @PathVariable String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
            mView.addObject("userInfo",userService.userDetail(request,userNo));
            mView.addObject("ctiUserInfo",userService.userCtiDetail(request,userNo));
            mView.addObject("siteLicense",licenseService.useSiteLicenseList(request));
            mView.addObject("userLicense",licenseService.userLicenseList(request,userNo));
            mView.setViewName("page/membership/member/memberDetail");
        return mView;
    }
    // 회원 수정화면
    @RequestMapping(value="/company/user/modified/{userNo}",method=RequestMethod.GET)
    public ModelAndView authUserUpdate(HttpServletRequest request,@PathVariable String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
            mView.addObject("userInfo",userService.userDetail(request,userNo));
            mView.addObject("ctiUserInfo",userService.userCtiDetail(request,userNo));
            mView.addAllObjects( codeService.getCommonCode(USINGMENU));
            mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
            mView.setViewName("page/membership/member/memberUpdate");
        return mView;
    }

    // 회원 수정
    @RequestMapping(value="/company/user/modified/{userNo}",method=RequestMethod.POST)
    public ModelAndView authUserUpdateSet(HttpServletRequest request, @PathVariable String userNo, @ModelAttribute UserDto userDto, @ModelAttribute UserCtiDto userCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        userService.userUpdate(request,userNo,userDto,userCtiDto);

        mView.setViewName("redirect:/company/user/"+userNo);
        return mView;
    }

    @RequestMapping(value="/company/user/del/{userNo}",method=RequestMethod.POST)
    public String authUserDelete(HttpServletRequest request, @PathVariable String userNo) throws UnsupportedEncodingException, GeneralSecurityException {

        userService.userDelete(request,userNo);

        return "redirect:/company/user";
    }

    @RequestMapping(value="/company/user/license/{userNo}",method=RequestMethod.POST)
    public ModelAndView authUserLicenseInsert(HttpServletResponse response,HttpServletRequest request, @PathVariable String userNo) throws GeneralSecurityException, UnsupportedEncodingException {
        ModelAndView mView = new ModelAndView();
        licenseService.userMenuInsert(request,userNo);
        mView.setViewName("redirect:/company/user/"+userNo);

        return mView;
    }
}
