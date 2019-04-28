package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/index/sitenotice", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authGetsiteNoticeList(HttpServletRequest request){
        List<Map<String,Object>> noticeList = noticeService.indexSiteNotice(request);
        return noticeList;
    }

    @RequestMapping(value = "/index/vocnotice", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authGetsiteNoticeLists(HttpServletRequest request){
        List<Map<String,Object>> noticeList = noticeService.indexVocNotice(request);
        return noticeList;
    }
}
