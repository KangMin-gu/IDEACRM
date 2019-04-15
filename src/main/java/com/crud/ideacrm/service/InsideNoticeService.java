package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.InsideNoticeDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface InsideNoticeService {
    public List<Map<String, Object>> alarmNotRead(HttpServletRequest request);
    public ModelAndView inboxList(HttpServletRequest request);
    public void inboxEyeChk(HttpServletRequest request, List<Integer> noticeid);
    public void inboxTrashChk(HttpServletRequest request, List<Integer> noticeid);
    public ModelAndView outboxList(HttpServletRequest request);
    public ModelAndView trashbox(HttpServletRequest request);
    public void noteDeleteChk(HttpServletRequest request, List<Integer> noticeid);
    public void noteReturnChk(HttpServletRequest request, List<Integer> noticeid);
    public ModelAndView composeData(HttpServletRequest request);
    public int send(HttpServletResponse response, HttpServletRequest request, InsideNoticeDto insDto);
}
