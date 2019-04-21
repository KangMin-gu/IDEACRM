package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.NoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Repository
public class NoticeDaoImple implements NoticeDao {

    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> siteNoticeList(Map<String, Object> param) {
        List<Map<String, Object>> noticeList = session.selectList("notice.companyNoticeList", param);
        return noticeList;
    }

    @Override
    public Map<String, Object> siteNoticeDetail(int noticeId) {
        Map<String, Object> notice = session.selectOne("notice.companyNoticeDetail", noticeId);
        return notice;
    }

    @Override
    public int siteNoticeInsert(NoticeDto noticeDto) {
        session.insert("notice.companyNoticeInsert", noticeDto);
        int noticeId = noticeDto.getNtnum();
        return noticeId;
    }
}
