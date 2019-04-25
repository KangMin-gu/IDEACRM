package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.UserDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.LoginService;
import com.crud.ideacrm.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private LoginService login;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private CodeService codeService;

    private final int NOTICE = 5;

    //로그인폼요청
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView loginForm(HttpServletRequest request) {

        String url=request.getParameter("url");

        if(url==null){
            url=request.getContextPath()+"/";
        }

        ModelAndView mView = noticeService.loginNotice();
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

    //전체공지사항 팝업
    @RequestMapping(value = "/pop/notice", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> popAllNoticeData(HttpServletRequest request){
        List<Map<String,Object>> noticeList = noticeService.noticeList(request);
        return noticeList;
    }

    @RequestMapping(value = "/pop/notice", method = RequestMethod.GET)
    public ModelAndView popAllNotice(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/popup/noticePop");
        return mView;
    }

    @RequestMapping(value = "/pop/notice/{noticeId}", method = RequestMethod.GET)
    public ModelAndView popAllnoticeDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.noticeDetail(request, noticeId);
        mView.setViewName("page/popup/noticeDetailPop");
        return mView;
    }

}
