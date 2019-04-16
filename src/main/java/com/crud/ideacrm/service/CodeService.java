package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CodeDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CodeService {
    public Map<String,Object> getCommonCode(int usingMenu);
    public Map<String,Object> getCustomCode(int usingMenu,HttpServletRequest request);
    public Map<String,Object> getCode(CodeDto codeDto);

    public List<CodeDto> getUpperCodeGrp(HttpServletRequest request);
}
