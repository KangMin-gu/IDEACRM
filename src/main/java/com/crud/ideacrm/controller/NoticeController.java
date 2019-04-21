package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dto.NoticeDto;
import com.crud.ideacrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/company/notice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView authsiteNoticeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/notice/noticeList");
        return mView;
    }

    @RequestMapping(value = "/company/notice", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authGetsiteNoticeList(HttpServletRequest request){
        List<Map<String,Object>> noticeList = noticeService.siteNoticeList(request);
        return noticeList;
    }

    @RequestMapping(value = "/company/notice/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authsiteNoticeDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.siteNoticeDetail(request, noticeId);
        mView.setViewName("page/membership/notice/noticeDetail");
        return mView;
    }

    @RequestMapping(value = "/company/notice/input", method = RequestMethod.GET)
    public ModelAndView authsiteNoticeInsertForm(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/notice/noticeInsert");
        return mView;
    }

    @RequestMapping(value = "/company/notice/input", method = RequestMethod.POST)
    public String authsiteNoticeInsert(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.siteNoticeInsert(response, request, noticeDto);
        return "redirect:/company/notice/"+noticeId;
    }

}
