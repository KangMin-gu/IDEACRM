package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.dao.LicenseDao;
import com.crud.ideacrm.dto.UseLicenseDto;
import com.crud.ideacrm.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LicenseServiceImple implements LicenseService {
    private static final Logger logger = LoggerFactory.getLogger(LicenseService.class);
    @Autowired
    private LicenseDao licenseDao;
    @Autowired
    private CodecUtil codecUtil;

    @Override
    public List<Map<String, Object>> licenseList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        String siteId = request.getSession().getAttribute("ENCSITEID").toString();
        siteId = codecUtil.decodePkNo(siteId);
        List<Map<String,Object>> licenseList = licenseDao.licenseList(siteId);
        return licenseList;
    }

    @Override
    public List<Map<String, Object>> allLicenseList() {
        List<Map<String,Object>> allLicenseList = licenseDao.allLicenseList();
        return allLicenseList;
    }

    @Override
    public List<Map<String, Object>> siteLicenseDetail(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        siteId = codecUtil.decodePkNo(siteId);
        List<Map<String,Object>> siteLicenseDetail = licenseDao.licenseList(siteId);
        return siteLicenseDetail;
    }

    @Override
    public void useLicenseInsert(HttpServletRequest request, UseLicenseDto useLicenseDto, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        siteId = codecUtil.decodePkNo(siteId);
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        List<UseLicenseDto> useLicenseDtoList = useLicenseDto.getUseLicenseDtoList();
        int listSize = useLicenseDtoList.size();
        useLicenseDto.setSiteid(siteId);
        useLicenseDto.setReguser(userNo);
        useLicenseDto.setEdtuser(userNo);
        for(int i = 0; i < listSize; i++ ){
            useLicenseDto.setLicensecnt(useLicenseDtoList.get(i).getLicensecnt());
            useLicenseDto.setLicenseno(useLicenseDtoList.get(i).getLicenseno());

            if(useLicenseDtoList.get(i).getIsdelete().equals("")){
                useLicenseDto.setIsdelete("1");
            }else{
                useLicenseDto.setIsdelete(useLicenseDtoList.get(i).getIsdelete());
            }
            licenseDao.siteLicenseInsert(useLicenseDto);
        }
    }

    @Override
    public List<Map<String, Object>> userLicenseList(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        userNo = codecUtil.decodePkNo(userNo);

        UserDto userDto = new UserDto();
        userDto.setUserno(userNo);
        userDto.setSiteid(siteId);

        List<Map<String,Object>> userLicenseList = licenseDao.userLicenseList(userDto);

        return userLicenseList;
    }

    @Override
    public List<Map<String, Object>> useSiteLicenseList(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        List<Map<String,Object>> useSiteLicenseList = licenseDao.useSiteLicenseList(siteId);


        return useSiteLicenseList;
    }

    @Override
    public void userMenuInsert(HttpServletRequest request,String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int sessionUserNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        userNo = codecUtil.decodePkNo(userNo);

        Map<String,Object> param = new HashMap<>();
        param.put("siteid",siteId);
        param.put("userno",userNo);
        param.put("sessionuserno",sessionUserNo);

        String license[] = request.getParameterValues("licenseno");


        licenseDao.menuReset(param);
        if(license == null){
        }else{
            int licenseSize = license.length;
            for(int i=0;i < licenseSize; i ++){
                param.put("licenseno",Integer.parseInt(license[i]));
                licenseDao.menuInsert(param);
            }
        }
    }

    @Override
    public List<Map<String, Object>> siteLicenseList(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        List<Map<String,Object>> siteLicenseList = licenseDao.siteLicenseList(siteId);
        return siteLicenseList;
    }
}
