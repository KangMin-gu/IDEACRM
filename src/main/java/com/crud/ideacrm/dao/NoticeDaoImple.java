package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.NoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @Override
    public int siteNoticeUpdate(NoticeDto noticeDto) {
        session.update("notice.companyNoticeUpdate",noticeDto);
        int noticeId = noticeDto.getNtnum();
        return noticeId;
    }

    @Override
    public void siteNoticeDel(NoticeDto noticeDto) {
        session.update("notice.companyNoticeDel", noticeDto);
    }

    @Override
    public List<Map<String, Object>> noticeList(Map<String, Object> param) {
        List<Map<String, Object>> noticeList = session.selectList("notice.noticeList", param);
        return noticeList;
    }

    @Override
    public Map<String, Object> noticeDetail(int noticeId) {
        Map<String, Object> notice = session.selectOne("notice.noticeDetail", noticeId);
        return notice;
    }

    @Override
    public int noticeInsert(NoticeDto noticeDto) {
        session.insert("notice.noticeInsert", noticeDto);
        int noticeId = noticeDto.getNtnum();
        return noticeId;
    }

    @Override
    public int noticeUpdate(NoticeDto noticeDto) {
        session.update("notice.noticeUpdate",noticeDto);
        int noticeId = noticeDto.getNtnum();
        return noticeId;
    }

    @Override
    public void noticeDel(NoticeDto noticeDto) {
        session.update("notice.noticeDel", noticeDto);
    }

    @Override
    public List<Map<String, Object>> vocNoticeList(Map<String, Object> param) {
        List<Map<String, Object>> noticeList = session.selectList("notice.vocNoticeList", param);
        return noticeList;
    }

    @Override
    public Map<String, Object> vocNoticeDetail(int noticeId) {
        Map<String, Object> notice = session.selectOne("notice.vocNoticeDetail", noticeId);
        return notice;
    }

    @Override
    public void vocNoticeReadCount(int noticeId) {
        session.update("notice.vocReadCount", noticeId);
    }

    @Override
    public int vocNoticeInsert(NoticeDto noticeDto) {
        session.insert("notice.vocNoticeInsert", noticeDto);
        int noticeId = noticeDto.getNtnum();
        return noticeId;
    }

    @Override
    public int vocNoticeUpdate(NoticeDto noticeDto) {
        session.update("notice.vocNoticeUpdate",noticeDto);
        int noticeId = noticeDto.getNtnum();
        return noticeId;
    }

    @Override
    public void vocNoticeDel(NoticeDto noticeDto) {
        session.update("notice.vocNoticeDel", noticeDto);
    }

    @Override
    public List<Map<String, Object>> loginNotice() {
        List<Map<String, Object>> notice = session.selectList("notice.loginNotice");
        return notice;
    }

    @Override
    public List<Map<String, Object>> indexSiteNotice(NoticeDto noticeDto) {
        List<Map<String, Object>> noticeList = session.selectList("notice.indexSiteNotice",noticeDto);
        return noticeList;
    }

    @Override
    public List<Map<String, Object>> indexVocNotice(NoticeDto noticeDto) {
        List<Map<String, Object>> noticeList = session.selectList("notice.indexVocNotice",noticeDto);
        return noticeList;
    }

}
