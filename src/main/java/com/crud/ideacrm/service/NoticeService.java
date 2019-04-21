package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.NoticeDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface NoticeService {

    public List<Map<String,Object>> siteNoticeList (HttpServletRequest request);
    public ModelAndView siteNoticeDetail(HttpServletRequest request, int noticeId);
    public int siteNoticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto);

}
