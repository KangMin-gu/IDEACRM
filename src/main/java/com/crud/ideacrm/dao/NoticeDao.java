package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.NoticeDto;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface NoticeDao {

    public List<Map<String, Object>> siteNoticeList(Map<String,Object> param);
    public Map<String, Object> siteNoticeDetail(int siteId);
    public int siteNoticeInsert(NoticeDto noticeDto);
}
