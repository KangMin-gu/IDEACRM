package com.crud.ideacrm.service;


import com.crud.ideacrm.dao.CodeDao;
import com.crud.ideacrm.dto.CodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodeServiceImple implements CodeService {
    @Autowired
    private CodeDao codeDao;
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
        //final int MASTER_SITEID = 1;
        //int commonFlag = paramCodeDto.getCommonflag();

        for(int i = 0; i < codeGrpListLength; i++) {
            CodeDto codeDto = new CodeDto();
            codeDto.setCodegrp(codeGrpList.get(i));
            codeGrp = codeDto.getCodegrp();
            codeDto.setSiteid(siteId);
            codeMap.put(codeGrp, codeDao.getCodeList(codeDto) );
            /*
            List<CodeDto> codeList = codeDao.getCodeList(codeDto);
            if(commonFlag == CUSTOM_COMMONCODEFLAG && codeList.size() == 0 ){//회원사의 커스텀 코드 설정 값이 없다면 default 값으로 크루드회원사 설정값을 가져간다.
                codeDto.setSiteid(MASTER_SITEID);
                codeList = codeDao.getCodeList(codeDto);
            }
            */
        }
        return codeMap;
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
