package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.CtiDto;
import com.crud.ideacrm.dto.KakaoDto;
import com.crud.ideacrm.dto.SiteDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
public class SiteController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private CodeService codeService;

    private final static int USINGMENU = 0;

    //회원사 회사정보
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ModelAndView companyInfo(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/site/siteDetail");
        return mView;
    }

    //회원사목록
    @RequestMapping(value="/common/site", method= RequestMethod.GET)
    public ModelAndView siteList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.setViewName("page/membership/site/siteList");
        return mView;
    }

    //회원사 목록(footable)
    @RequestMapping(value="/common/site",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> siteiList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> siteList = siteService.siteList(request);
        return siteList;
    }

    //master 회원사 상세정보
    @RequestMapping(value="/common/site/{siteId}", method= RequestMethod.GET)
    public ModelAndView siteDetail(HttpServletRequest request, @PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

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
    public ModelAndView authSiteInsertSet(HttpServletRequest request, @ModelAttribute SiteDto siteDto, @ModelAttribute CtiDto ctiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        String siteId = siteService.siteInsert(request,siteDto,ctiDto);
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
    public ModelAndView authSiteUpdateSet(HttpServletRequest request,@PathVariable String siteId,@ModelAttribute SiteDto siteDto,@ModelAttribute CtiDto ctiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        siteService.siteUpdate(request,siteId,siteDto,ctiDto);
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
}
