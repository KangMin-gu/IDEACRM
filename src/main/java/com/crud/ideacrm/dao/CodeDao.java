package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CodeDto;

import java.util.List;
import java.util.Map;

public interface CodeDao {
    public List<String> getCodeGrpList(CodeDto codeDto);
    public List<CodeDto> getCodeList(CodeDto codeDto);
    public List<Map<String,Object>> codeList(Map<String,Object> param);
    public String getCodeNo(CodeDto codeDto);
    public List<CodeDto> getUpperCodeGrp(CodeDto codeDto);

    public Map<String,Object> codeDetail(CodeDto codeDto);
    public String codeInsert(CodeDto codeDto);
    public void codeUpdate(CodeDto codeDto);
    public void codeDelete(CodeDto codeDto);
}
