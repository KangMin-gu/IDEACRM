package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CodeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<String, Object>> codeList(Map<String, Object> param) {
        List<Map<String,Object>> codeList = session.selectList("code.codeList",param);
        return codeList;
    }

    // 상위 코드 값으로 하위 코드 값을 가져옴
    @Override
    public List<CodeDto> getUpperCodeGrp(CodeDto codeDto) {
        List<CodeDto> upperGrpCodeList = session.selectList("code.getUpperCodeGrp",codeDto);
        return upperGrpCodeList;
    }

    @Override
    public Map<String, Object> codeDetail(CodeDto codeDto) {
        Map<String,Object> codeDetail = session.selectOne("code.codeDetail",codeDto);
        return codeDetail;
    }

    @Override
    public String codeInsert(CodeDto codeDto) {
        session.insert("code.codeInsert",codeDto);
        String codeNo = codeDto.getCodeno();

        return codeNo;
    }

    @Override
    public void codeUpdate(CodeDto codeDto) {
        session.update("code.codeUpdate",codeDto);
    }

    @Override
    public void codeDelete(CodeDto codeDto) {
        session.update("code.codeDelete",codeDto);
    }

    @Override
    public String getCodeNo(CodeDto codeDto) {
        String codeNo = session.selectOne("code.getCodeNo",codeDto);
        return codeNo;
    }

}
