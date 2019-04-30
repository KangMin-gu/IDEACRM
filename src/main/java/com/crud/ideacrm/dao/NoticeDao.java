package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.NoticeDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface NoticeDao {

    public List<Map<String, Object>> siteNoticeList(Map<String,Object> param);
    public Map<String, Object> siteNoticeDetail(int noticeId);
    public int siteNoticeInsert(NoticeDto noticeDto);
    public int siteNoticeUpdate(NoticeDto noticeDto);
    public void siteNoticeDel(NoticeDto noticeDto);
    public List<Map<String, Object>> noticeList(Map<String,Object> param);
    public Map<String, Object> noticeDetail(int noticeId);
    public int noticeInsert(NoticeDto noticeDto);
    public int noticeUpdate(NoticeDto noticeDto);
    public void noticeDel(NoticeDto noticeDto);
    public List<Map<String, Object>> vocNoticeList(Map<String,Object> param);
    public Map<String, Object> vocNoticeDetail(int noticeId);
    public void vocNoticeReadCount(int noticeId);
    public int vocNoticeInsert(NoticeDto noticeDto);
    public int vocNoticeUpdate(NoticeDto noticeDto);
    public void vocNoticeDel(NoticeDto noticeDto);
    public List<Map<String, Object>> loginNotice();
    public List<Map<String,Object>> indexSiteNotice(NoticeDto noticeDto);
    public List<Map<String,Object>> indexVocNotice(NoticeDto noticeDto);
}
