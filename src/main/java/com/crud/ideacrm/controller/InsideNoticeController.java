package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.InsideNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class InsideNoticeController {

    @Autowired
    private InsideNoticeService isns;

    //알람_안읽은편지
    @RequestMapping(value = "/insnotread", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> authAlarmNotRead(HttpServletRequest request){
        List<Map<String, Object>> alarmNotRead = isns.alarmNotRead(request);
        return alarmNotRead;
    }

    //받은통지리스트
    @RequestMapping(value = "/inbox", method = RequestMethod.GET)
    public ModelAndView authinboxList(HttpServletRequest request){
        ModelAndView mView = isns.inboxList(request);
        mView.setViewName("page/membership/insideNotice/inBox");
        return mView;
    }
    //받은통지검색
    @RequestMapping(value = "/inbox", method = RequestMethod.POST)
    public ModelAndView authinboxListSearch(HttpServletRequest request){
        ModelAndView mView = isns.inboxList(request);
        mView.setViewName("page/membership/insideNotice/inBox");
        return mView;
    }
    //받은통지 읽음체크
    @RequestMapping(value="/eyechk", method=RequestMethod.GET)
    @ResponseBody
    public void authInboxEyeChk(HttpServletRequest request, @RequestParam(value="checkArr[]") List<Integer> noticeid) {
        isns.inboxEyeChk(request, noticeid);
    }
    //휴지통으로 이동
    @RequestMapping(value="/trashchk", method=RequestMethod.GET)
    @ResponseBody
    public void authnoteTrashChk(HttpServletRequest request, @RequestParam(value="checkArr[]") List<Integer> noticeid) {
        isns.inboxTrashChk(request, noticeid);
    }















    @RequestMapping(value = "/outbox", method = RequestMethod.GET)
    public ModelAndView outboxList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/outBox");
        return mView;
    }

    @RequestMapping(value = "/trashbox", method = RequestMethod.GET)
    public ModelAndView trashboxList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/trashBox");
        return mView;
    }

    @RequestMapping(value = "/compose", method = RequestMethod.GET)
    public ModelAndView sendForm(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/sendForm");
        return mView;
    }

    @RequestMapping(value = "/inbox/1", method = RequestMethod.GET)
    public ModelAndView boxDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/insideNotice/boxDetail");
        return mView;
    }

}
