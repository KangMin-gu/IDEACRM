package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CodeDto;

import java.util.Map;

public interface CodeService {
    public Map<String,Object> getCommonCode(int usingMenu);
    public Map<String,Object> getCustomCode(CodeDto paramCodeDto);
    public Map<String,Object> getCode(int usingMenu, int siteId);
    public Map<String,Object> getCode(CodeDto codeDto);
}