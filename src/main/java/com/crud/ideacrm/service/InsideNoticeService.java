package com.crud.ideacrm.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface InsideNoticeService {
    public List<Map<String, Object>> alarmNotRead(HttpServletRequest request);
    public ModelAndView inboxList(HttpServletRequest request);
    public void inboxEyeChk(HttpServletRequest request, List<Integer> noticeid);
    public void inboxTrashChk(HttpServletRequest request, List<Integer> noticeid);
    public ModelAndView outboxList(HttpServletRequest request);
}
