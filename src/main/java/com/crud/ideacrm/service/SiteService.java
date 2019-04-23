package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.SiteCtiDto;
import com.crud.ideacrm.dto.SiteDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface SiteService {

    public List<Map<String,Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    public ModelAndView siteDetail (HttpServletRequest request,String siteId) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> ctiDetail(HttpServletRequest request);

    public String siteInsert(HttpServletResponse response,HttpServletRequest request, SiteDto siteDto, SiteCtiDto siteCtiDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public void siteUpdate(HttpServletResponse response, HttpServletRequest request, String siteId, SiteDto siteDto, SiteCtiDto siteCtiDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public void siteDelete(HttpServletRequest request,String siteId) throws UnsupportedEncodingException, GeneralSecurityException;

    public Map<String, Object> totalMoney(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException;

}
