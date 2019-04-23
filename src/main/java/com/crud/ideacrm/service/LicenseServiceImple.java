package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.dao.LicenseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class LicenseServiceImple implements LicenseService {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private LicenseDao licenseDao;
    @Autowired
    private CodecUtil codecUtil;

    @Override
    public List<Map<String, Object>> siteLicenseList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        String siteId = request.getSession().getAttribute("ENCSITEID").toString();
        siteId = codecUtil.decodePkNo(siteId);
        List<Map<String,Object>> siteLicenseList = licenseDao.siteLicenseList(siteId);
        return siteLicenseList;
    }

    @Override
    public List<Map<String, Object>> allLicenseList() {
        List<Map<String,Object>> allLicenseList = licenseDao.allLicenseList();
        return allLicenseList;
    }

    @Override
    public List<Map<String, Object>> siteLicenseDetail(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        siteId = codecUtil.decodePkNo(siteId);
        List<Map<String,Object>> siteLicenseDetail = licenseDao.siteLicenseList(siteId);
        return siteLicenseDetail;
    }
}
