package com.crud.ideacrm.service;


import com.crud.ideacrm.dao.CodeDao;
import com.crud.ideacrm.dto.CodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodeServiceImple implements CodeService {
    @Autowired
    private CodeDao codeDao;

    @Override//해당 모듈에서 사용하는 공통코드 리턴. 캐쉬
    @Cacheable("code")
    public Map<String, Object> getCommonCode(String moduleName, int siteid) {
        Map<String, Object> commonCodeMap = new HashMap<String, Object>();//공통코드

        final int COMMON_SITEID = 0;//공통코드용 siteid 셋팅

        //Todo. 하드코딩부분 아래 주석코드로 변경
        //List<String> commonCodeGrpList = codeDao.getCodeGrpList(codeDto);//공통코드  dto에 접근루트, 공통 여부 설정.

        List<String> commonCodeGrpList = new ArrayList<String>();
        commonCodeGrpList.add("INFOAGREE");
        commonCodeGrpList.add("PHONE");
        commonCodeGrpList.add("FAX");
        commonCodeGrpList.add("MOBILE");
        commonCodeGrpList.add("SOLAR");
        commonCodeGrpList.add("MAILTO");
        commonCodeGrpList.add("MARRIED");

        //공통코드 map에 셋팅
        int comCodeGrpListLength = commonCodeGrpList.size();
        String codeGrp;
        for(int i = 0; i < comCodeGrpListLength; i++) {
            CodeDto commCodeDto = new CodeDto();
            commCodeDto.setCodegrp(commonCodeGrpList.get(i));
            codeGrp = commCodeDto.getCodegrp();
            commCodeDto.setSiteid(COMMON_SITEID);//공통코드는 siteid 0
            commonCodeMap.put(codeGrp, codeDao.getCodeList(commCodeDto));//codeDao.getCommonCodeList는 캐쉬 설정 된다.
        }


        return commonCodeMap;
    }

    @Override//해당 모듈에서 사용하는 회원사별 코드 리턴.
    public Map<String, Object> getCustomCode(String moduleName, int siteid) {
        Map<String, Object> customCodeMap = new HashMap<String, Object>();//회원사별코드

        //Todo. 하드코딩부분 아래 주석코드로 변경
        //List<String> customCodeGrpList = codeDao.getCodeGrpList(codeDto);//회원사별코드 dto에 접근루트, 공통 여부 설정.
        List<String> customCodeGrpList = new ArrayList<String>();
        customCodeGrpList.add("CUSTGUBUN");
        customCodeGrpList.add("CUSTGRADE");
        customCodeGrpList.add("ACTGRADE");

        //회원사별코드 map에 셋팅
        int customCodeGrpListLength = customCodeGrpList.size();
        String codeGrp;
        for(int i = 0; i < customCodeGrpListLength; i++) {
            CodeDto customCodeDto = new CodeDto();
            customCodeDto.setCodegrp(customCodeGrpList.get(i));
            codeGrp = customCodeDto.getCodegrp();
            customCodeDto.setSiteid(siteid);//siteid 로그인한 회원사 코드로 셋팅
            customCodeMap.put(codeGrp, codeDao.getCodeList(customCodeDto));
        }

        return customCodeMap;
    }

    public void test(){
        System.out.println("@@@@@@");
    }
}
