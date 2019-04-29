package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.FormatDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FormatDaoImple implements FormatDao {

    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> formatList(Map<String, Object> param) {
        List<Map<String,Object>> formatList = session.selectList("format.formatList",param);
        return formatList;
    }

    @Override
    public String formatInsert(FormatDto formatDto) {
        session.insert("format.formatInsert",formatDto);
        String formatNo = formatDto.getFormatno();
        return formatNo;
    }

    @Override
    public Map<String, Object> formatDetail(FormatDto formatDto) {
        Map<String,Object> formatDetail = session.selectOne("format.formatDetail",formatDto);
        return formatDetail;
    }

    @Override
    public void formatUpdate(FormatDto formatDto) {
        session.update("format.formatUpdate",formatDto);
    }

    @Override
    public void formatDelete(FormatDto formatDto) {
        session.update("format.formatDelete",formatDto);
    }

    @Override
    public List<Map<String, Object>> smsFormat(int siteId) {
        List<Map<String, Object>> formatList = session.selectList("format.smsFormat", siteId);
        return formatList;
    }

    @Override
    public List<Map<String, Object>> emailFormat(int siteId) {
        List<Map<String, Object>> formatList = session.selectList("format.emailFormat", siteId);
        return formatList;
    }

    @Override
    public Map<String, Object> formatdesc(int formatNum) {
        Map<String, Object> formatdesc = session.selectOne("format.formatdesc", formatNum);
        return formatdesc;
    }
}
