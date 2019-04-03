package com.crud.ideacrm.service;


import com.crud.ideacrm.dao.CodeDao;
import com.crud.ideacrm.dto.CodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodeServiceImple implements CodeService {
    @Autowired
    private CodeDao codeDao;
    private final int COMMON_COMMONCODEFLAG = 0;
    private final int CUSTOM_COMMONCODEFLAG = 1;

    @Override//해당 모듈에서 사용하는 공통코드 리턴. 캐쉬
    @Cacheable("code")
    public Map<String, Object> getCommonCode(int usingMenu) {
        CodeDto codeDto = new CodeDto();
        codeDto.setUsingmenu(usingMenu);
        codeDto.setCommonflag(COMMON_COMMONCODEFLAG);
        return getCode(codeDto);
    }

    @Override
    public Map<String,Object> getCustomCode(int usingMenu, int siteId) {
        CodeDto codeDto = new CodeDto();
        codeDto.setUsingmenu(usingMenu);
        codeDto.setSiteid(siteId);
        codeDto.setCommonflag(CUSTOM_COMMONCODEFLAG);
        return getCode(codeDto);
    }

    @Override
    public Map<String, Object> getCode(CodeDto paramCodeDto) {//siteid, usingmenu, commonflag
        Map<String, Object> codeMap = new HashMap<String, Object>();//공통코드

        List<String> codeGrpList = codeDao.getCodeGrpList(paramCodeDto);//공통코드  dto에 접근루트, 공통 여부 설정.

        //공통코드 map에 셋팅
        int codeGrpListLength = codeGrpList.size();
        String codeGrp;
        int siteId = paramCodeDto.getSiteid();

        for(int i = 0; i < codeGrpListLength; i++) {
            CodeDto codeDto = new CodeDto();
            codeDto.setCodegrp(codeGrpList.get(i));
            codeGrp = codeDto.getCodegrp();
            codeDto.setSiteid(siteId);
            codeMap.put(codeGrp, codeDao.getCodeList(codeDto));
        }
        return codeMap;
    }




}
