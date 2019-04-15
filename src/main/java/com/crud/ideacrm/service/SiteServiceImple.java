package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CrudCommonUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.SiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
@Service
public class SiteServiceImple implements SiteService{

    @Autowired
    private SiteDao siteDao;
    @Autowired
    private CrudCommonUtil commonUtil;

    @Override
    public List<Map<String, Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> siteList = siteDao.siteList(param);
/*
        for(int i=0;i<siteList.size();i++){ //pk값 암호화
            String deSiteId = "";
            deSiteId = siteList.get(i).get("SITEID").toString();
            String enSiteId = commonUtil.encodePkNo(deSiteId);
            siteList.get(i).put("SITEID",enSiteId);
        }
        return commonUtil.decodeList(siteList);
        */
        return siteList;
    }

    @Override
    public ModelAndView siteDetail(HttpServletRequest request, String siteId) {
        ModelAndView mView = new ModelAndView();
        Map<String,Object> siteDetail = siteDao.siteDetail(siteId);
        Map<String,Object> siteCtiDetail = siteDao.siteCtiDetail(siteId);
        List<Map<String,Object>> siteKkoDetail = siteDao.siteKkoDetail(siteId);

        mView.addObject("siteInfo",siteDetail);
        mView.addObject("ctiInfo",siteCtiDetail);
        mView.addObject("kkoInfo",siteKkoDetail);
        return mView;
    }
}
