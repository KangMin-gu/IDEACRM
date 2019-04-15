package com.crud.ideacrm.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface SiteService {

    public List<Map<String,Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    public ModelAndView siteDetail (HttpServletRequest request,String siteId);

}
