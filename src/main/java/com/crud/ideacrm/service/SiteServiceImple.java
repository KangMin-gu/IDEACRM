package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.SiteDao;
import com.crud.ideacrm.dto.CtiDto;
import com.crud.ideacrm.dto.KakaoDto;
import com.crud.ideacrm.dto.SiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private CodecUtil codecUtil;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<Map<String, Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> siteList = siteDao.siteList(param);

        for(int i=0;i<siteList.size();i++){ //pk값 암호화
            String deSiteId = "";
            deSiteId = siteList.get(i).get("NO").toString();
            String enSiteId = codecUtil.encodePkNo(deSiteId);
            siteList.get(i).put("NO",enSiteId);
        }
//        return commonUtil.decodeList(siteList);
        return siteList;
    }

    @Override
    public ModelAndView siteDetail(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String deCustNo = codecUtil.decodePkNo(siteId);//복호화 후 전달
        Map<String,Object> siteDetail = siteDao.siteDetail(deCustNo);
        Map<String,Object> siteCtiDetail = siteDao.siteCtiDetail(deCustNo);
        List<Map<String,Object>> siteKkoDetail = siteDao.siteKkoDetail(deCustNo);
        siteDetail.put("SITEID",siteId);

        mView.addObject("siteInfo",siteDetail);
        mView.addObject("ctiInfo",siteCtiDetail);
        mView.addObject("kkoInfo",siteKkoDetail);
        return mView;
    }

    @Override
    public String siteInsert(HttpServletRequest request, SiteDto siteDto, CtiDto ctiDto, KakaoDto kakaoDto) throws UnsupportedEncodingException, GeneralSecurityException {

        String siteId = siteDao.siteInsert(siteDto);

        String EncodePass = encoder.encode(siteDto.getAdminpassword());
        siteDto.setAdminpassword(EncodePass);
        siteDao.siteUserInsert(siteDto);

        if(siteId != null){
            ctiDto.setSiteid(siteId);
            String ctiIp = ctiDto.getIp();
            String kakaoPlus = kakaoDto.getPlusfriend();

            if(!ctiIp.equals("") ){
                siteDao.ctiInsert(ctiDto);
            }
            if(kakaoPlus != null){
                kakaoDto.setSiteid(siteId);
                siteDao.kakaoInsert(kakaoDto);
            }
        }
        siteId = codecUtil.encodePkNo(siteId);
        return siteId;
    }

    @Override
    public void siteDelete(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

        String decSiteId = codecUtil.decodePkNo(siteId);
        siteDao.siteDelete(decSiteId);
    }
}
