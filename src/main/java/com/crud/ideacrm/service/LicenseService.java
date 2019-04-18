package com.crud.ideacrm.service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface LicenseService {
    public List<Map<String,Object>> siteLicenseList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String,Object>> allLicenseList();

    public List<Map<String,Object>> siteLicenseDetail(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException;
}
