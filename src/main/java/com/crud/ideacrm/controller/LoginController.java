package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.RServeExample;
import com.crud.ideacrm.dto.UserDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.LoginService;
import com.crud.ideacrm.service.NoticeService;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @Autowired
    private RServeExample rser;

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

    @RequestMapping(value = "/r", method = RequestMethod.GET)
    public ModelAndView r(HttpServletRequest request) throws REngineException, REXPMismatchException {
        ModelAndView mView = new ModelAndView();

        REXP a = rser.getRVersion();
        double[] b = rser.assignJ2R();
        String aa = a.asString();
        mView.addObject("a", aa);
        mView.addObject("b", b);

        mView.setViewName("r");
        return mView;
    }

    @RequestMapping(value = "/mail/check", method = RequestMethod.GET)
    @ResponseBody
    public void rs(HttpServletRequest request) {
      System.out.println("들어왔습니다~!212121212");
    }
}
