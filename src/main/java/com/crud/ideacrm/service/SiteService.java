package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.SiteCtiDto;
import com.crud.ideacrm.dto.SiteDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface SiteService {

    public List<Map<String,Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    public ModelAndView siteDetail (HttpServletRequest request,String siteId) throws UnsupportedEncodingException, GeneralSecurityException;

    public String siteInsert(HttpServletRequest request, SiteDto siteDto, SiteCtiDto ctiDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public void siteUpdate(HttpServletRequest request, String siteId, SiteDto siteDto, SiteCtiDto ctiDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public void siteDelete(HttpServletRequest request,String siteId) throws UnsupportedEncodingException, GeneralSecurityException;

    public Map<String, Object> totalMoney(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException;

}
