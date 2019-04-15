package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value="/common/site",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> siteiList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> siteList = siteService.siteList(request);
        return siteList;
    }

    //master 회원사 상세정보
    @RequestMapping(value="/common/site/{siteId}", method= RequestMethod.GET)
    public ModelAndView siteDetail(HttpServletRequest request, @PathVariable String siteId){

        ModelAndView mView = siteService.siteDetail(request,siteId);
        mView.setViewName("page/membership/site/siteDetail");
        return mView;
    }

    //회원사 등록
    @RequestMapping(value="/siteinsert", method= RequestMethod.GET)
    public ModelAndView siteInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();

        mView.setViewName("page/membership/site/siteInsert");
        return mView;
    }


}
