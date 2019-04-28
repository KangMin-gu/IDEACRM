package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.NoticeDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface NoticeService {

    public List<Map<String,Object>> siteNoticeList (HttpServletRequest request);
    public ModelAndView siteNoticeDetail(HttpServletRequest request, int noticeId);
    public int siteNoticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);
    public ModelAndView siteNoticeUpdateForm(HttpServletRequest request, int noticeId);
    public int siteNoticeUpdate(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);
    public void siteNoticeDel(HttpServletRequest request, int noticeId);
    public List<Map<String,Object>> noticeList (HttpServletRequest request);
    public ModelAndView noticeDetail(HttpServletRequest request, int noticeId);
    public int noticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);
    public ModelAndView noticeUpdateForm(HttpServletRequest request, int noticeId);
    public int noticeUpdate(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);
    public void noticeDel(HttpServletRequest request, int noticeId);
    public List<Map<String,Object>> vocNoticeList (HttpServletRequest request);
    public ModelAndView vocNoticeDetail(HttpServletRequest request, int noticeId);
    public int vocNoticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);
    public ModelAndView vocNoticeUpdateForm(HttpServletRequest request, int noticeId);
    public int vocNoticeUpdate(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);
    public void vocNoticeDel(HttpServletRequest request, int noticeId);
    public ModelAndView loginNotice();
    public List<Map<String,Object>> indexSiteNotice(HttpServletRequest request);
    public List<Map<String,Object>> indexVocNotice(HttpServletRequest request);
}
