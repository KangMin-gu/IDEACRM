package com.crud.ideacrm.service;


import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.CodeDao;
import com.crud.ideacrm.dto.CodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodeServiceImple implements CodeService {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private CodeDao codeDao;
    @Autowired
    private CodecUtil codecUtil;
    private final int COMMON_COMMONCODEFLAG = 0;
    private final int CUSTOM_COMMONCODEFLAG = 1;


    @Override//해당 모듈에서 사용하는 공통코드. 캐쉬
    @Cacheable("code")
    public Map<String, Object> getCommonCode(int usingMenu) {
        CodeDto codeDto = new CodeDto();
        codeDto.setUsingmenu(usingMenu);
        codeDto.setCommonflag(COMMON_COMMONCODEFLAG);
        return getCode(codeDto);
    }

    @Override//해당 모듈에서 사용하는 회원사별 코드
    public Map<String,Object> getCustomCode(int usingMenu, HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CodeDto codeDto = new CodeDto();
        codeDto.setUsingmenu(usingMenu);
        codeDto.setSiteid(siteId);
        codeDto.setCommonflag(CUSTOM_COMMONCODEFLAG);
        return getCode(codeDto);
    }

    @Override
    public Map<String, Object> getCode(CodeDto paramCodeDto) {//siteid, usingmenu, commonflag
        Map<String, Object> codeMap = new HashMap<String, Object>();//공통코드
        List<String> codeGrpList = codeDao.getCodeGrpList(paramCodeDto);//코드명의 목록을 받아온다. String[] codegrp

        int codeGrpListLength = codeGrpList.size();
        String codeGrp;
        int siteId = paramCodeDto.getSiteid();

        for(int i = 0; i < codeGrpListLength; i++) {
            CodeDto codeDto = new CodeDto();
            codeDto.setCodegrp(codeGrpList.get(i));
            codeGrp = codeDto.getCodegrp();
            codeDto.setSiteid(siteId);
            codeMap.put(codeGrp, codeDao.getCodeList(codeDto) );
        }
        return codeMap;
    }

    @Override
    public List<Map<String, Object>> codeList(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        siteId = codecUtil.decodePkNo(siteId);
        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);
        param.put("siteid",siteId);
        List<Map<String,Object>> codeList = codeDao.codeList(param);
        String deCodeNo = "";
        for(int i=0;i < codeList.size();i++){ //pk값 암호화
            deCodeNo = codeList.get(i).get("NO").toString();
            String enSiteId = codecUtil.encodePkNo(deCodeNo);
            codeList.get(i).put("NO",enSiteId);
        }
        return codeList;
    }

    @Override
    public Map<String, Object> codeDetail(HttpServletRequest request, String codeNo) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        codeNo = codecUtil.decodePkNo(codeNo);
        CodeDto codeDto = new CodeDto();
        codeDto.setCodeno(codeNo);
        codeDto.setSiteid(siteId);
        Map<String,Object> codeDetail = codeDao.codeDetail(codeDto);
        String encCodeNo = codeDetail.get("CODENO").toString();
        codeNo = codecUtil.encodePkNo(encCodeNo);
        codeDetail.put("CODENO",codeNo);

        return codeDetail;
    }

    @Override
    public String codeUpdate(HttpServletRequest request, CodeDto codeDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        codeDto.setEdtuser(userNo);
        codeDto.setSiteid(siteId);
        String encCodeNo = codeDto.getCodeno();
        String desCodeNo = codecUtil.decodePkNo(codeDto.getCodeno());
        codeDto.setCodeno(desCodeNo);
        codeDao.codeUpdate(codeDto);

        return encCodeNo;
    }

    @Override
    public String codeInsert(HttpServletRequest request, CodeDto codeDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        codeDto.setSiteid(siteId);
        codeDto.setReguser(userNo);
        codeDto.setEdtuser(userNo);

        String codeNo = codeDao.codeInsert(codeDto);

        return codecUtil.encodePkNo(codeNo);

    }

    @Override
    public void codeDelete(HttpServletRequest request, String codeNo) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        CodeDto codeDto = new CodeDto();
        codeDto.setEdtuser(userNo);
        codeDto.setSiteid(siteId);
        codeDto.setCodeno(codecUtil.decodePkNo(codeNo));

        codeDao.codeDelete(codeDto);
    }

    @Override
    public List<CodeDto> getUpperCodeGrp(HttpServletRequest request) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        String codeVal = request.getParameter("codeval").toString();
        String codeGrp = request.getParameter("codegrp").toString().toUpperCase();


        CodeDto codeDto = new CodeDto();
        codeDto.setSiteid(siteId);
        codeDto.setCodeval(codeVal);
        codeDto.setCodegrp(codeGrp);

        String getCodeNo = codeDao.getCodeNo(codeDto);

        codeDto.setUppercodegrp(getCodeNo);

        List<CodeDto> getUpperCodeGrp = codeDao.getUpperCodeGrp(codeDto);
        return getUpperCodeGrp;
    }

}
