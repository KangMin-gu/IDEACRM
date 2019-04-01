package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CodeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodeDaoImple implements CodeDao {
    @Autowired
    private SqlSession session;


    @Override
    public List<String> getCodeGrpList(CodeDto codeDto) {
        return session.selectList("code.getCodeGrpList",codeDto);
    }

    @Override
    public List<CodeDto> getCodeList(CodeDto codeDto) {//캐쉬에 올라갈  공통코드
        return session.selectList("code.getCodeList",codeDto);
    }

}
