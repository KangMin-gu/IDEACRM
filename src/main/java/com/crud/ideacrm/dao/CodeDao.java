package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CodeDto;

import java.util.List;

public interface CodeDao {
    public List<String> getCodeGrpList(CodeDto codeDto);
    public List<CodeDto> getCodeList(CodeDto codeDto);
}
