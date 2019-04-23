package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.SiteCtiDto;
import com.crud.ideacrm.dto.SiteDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.SiteService;
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
public class SiteController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private SiteService siteService;

    @Autowired
    private CodeService codeService;
    @Autowired
    private UserService userService;

    private final static int USINGMENU = 0;

    //회원사목록
    @RequestMapping(value="/common/site", method= RequestMethod.GET)
    public ModelAndView authSiteList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.setViewName("page/membership/site/siteList");
        return mView;
    }

    //회원사 목록(footable)
    @RequestMapping(value="/common/site",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authSiteiList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> siteList = siteService.siteList(request);
        return siteList;
    }

    //master 회원사 상세정보
    @RequestMapping(value="/common/site/{siteId}", method= RequestMethod.GET)
    public ModelAndView authSiteDetail(HttpServletRequest request, @PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

        ModelAndView mView = siteService.siteDetail(request,siteId);
        mView.setViewName("page/membership/site/siteDetail");
        return mView;
    }

    // master 회원사 추가 화면
    @RequestMapping(value = "/common/site/input", method = RequestMethod.GET)
    public ModelAndView authServiceInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/membership/site/siteInsert");
        return mView;
    }

    // master 회원사 추가
    @RequestMapping(value = "/common/site/input", method = RequestMethod.POST)
    public ModelAndView authSiteInsertSet(HttpServletResponse response,HttpServletRequest request, @ModelAttribute SiteDto siteDto, @ModelAttribute SiteCtiDto siteCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        String siteId = siteService.siteInsert(response, request,siteDto,siteCtiDto);
        mView.setViewName("redirect:/common/site/"+siteId);
        return mView;
    }

    //master 회원사 수정 화면
    @RequestMapping(value="/common/site/modified/{siteId}",method=RequestMethod.GET)
    public ModelAndView authSiteUpdate(HttpServletRequest request,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = siteService.siteDetail(request,siteId);
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("/page/membership/site/siteUpdate");
        return mView;
    }

    //master 회원사 수정
    @RequestMapping(value="/common/site/modified/{siteId}",method=RequestMethod.POST)
    public ModelAndView authSiteUpdateSet(HttpServletResponse response, HttpServletRequest request, @PathVariable String siteId, @ModelAttribute SiteDto siteDto, @ModelAttribute SiteCtiDto siteCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        siteService.siteUpdate(response, request,siteId,siteDto,siteCtiDto);
        mView.setViewName("redirect:/common/site/"+siteId);
        return mView;
    }

    @RequestMapping(value="/common/site/del/{siteId}",method=RequestMethod.POST)
    public ModelAndView authSiteDelte(HttpServletRequest request,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        siteService.siteDelete(request,siteId);
        mView.setViewName("redirect:/common/site");
        return mView;
    }

    @RequestMapping(value="/common/site/tab/user/{siteId}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authSiteTabUserList(HttpServletRequest request,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> tabUserList = userService.userTabList(siteId);
        return tabUserList;
    }

    @RequestMapping(value="/common/site/totalMoney/{siteId}",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> authTotalMoney(HttpServletRequest request,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> totalMoney = siteService.totalMoney(request,siteId);
        return totalMoney;
    }
}
