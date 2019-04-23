package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dto.NoticeDto;
import com.crud.ideacrm.service.CodeService;
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
    @Autowired
    private CodeService codeService;

    private final int NOTICE = 5;


    @RequestMapping(value = "/company/notice", method = RequestMethod.GET)
    public ModelAndView authsiteNoticeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
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
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/membership/notice/noticeInsert");
        return mView;
    }

    @RequestMapping(value = "/company/notice/input", method = RequestMethod.POST)
    public String authsiteNoticeInsert(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.siteNoticeInsert(response, request, noticeDto);
        return "redirect:/company/notice/"+noticeId;
    }

    @RequestMapping(value = "/company/notice/modified/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authsiteNoticeUpdateForm(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.siteNoticeUpdateForm(request, noticeId);
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/membership/notice/noticeUpdate");
        return mView;
    }

    @RequestMapping(value = "/company/notice/modified/{noticeId}", method = RequestMethod.POST)
    public String authsiteNoticeUpdate(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.siteNoticeUpdate(response, request, noticeDto);
        return "redirect:/company/notice/"+noticeId;
    }

    @RequestMapping(value = "/company/notice/del/{noticeId}", method = RequestMethod.GET)
    public String authsiteNoticeDel(HttpServletRequest request, @PathVariable int noticeId){
        noticeService.siteNoticeDel(request, noticeId);
        return "redirect:/company/notice";
    }

    //All NOTICE
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ModelAndView authNoticeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/membership/allNotice/noticeList");
        return mView;
    }

    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authGetNoticeList(HttpServletRequest request){
        List<Map<String,Object>> noticeList = noticeService.noticeList(request);
        return noticeList;
    }

    @RequestMapping(value = "/notice/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authNoticeDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.noticeDetail(request, noticeId);
        mView.setViewName("page/membership/allNotice/noticeDetail");
        return mView;
    }

    @RequestMapping(value = "/notice/input", method = RequestMethod.GET)
    public ModelAndView authNoticeInsertForm(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/allNotice/noticeInsert");
        return mView;
    }

    @RequestMapping(value = "/notice/input", method = RequestMethod.POST)
    public String authNoticeInsert(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.noticeInsert(response, request, noticeDto);
        return "redirect:/notice/"+noticeId;
    }


    @RequestMapping(value = "/notice/modified/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authNoticeUpdateForm(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.noticeUpdateForm(request, noticeId);
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/membership/allNotice/noticeUpdate");
        return mView;
    }

    @RequestMapping(value = "/notice/modified/{noticeId}", method = RequestMethod.POST)
    public String authNoticeUpdate(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.noticeUpdate(response, request, noticeDto);
        return "redirect:/notice/"+noticeId;
    }

    @RequestMapping(value = "/notice/del/{noticeId}", method = RequestMethod.GET)
    public String authNoticeDel(HttpServletRequest request, @PathVariable int noticeId){
        noticeService.noticeDel(request, noticeId);
        return "redirect:/notice";
    }

    //VOCNOTICE
    @RequestMapping(value = "/voc/notice", method = RequestMethod.GET)
    public ModelAndView authVocNoticeList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/membership/vocNotice/noticeList");
        return mView;
    }

    @RequestMapping(value = "/voc/notice", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authGetVocNoticeList(HttpServletRequest request){
        List<Map<String,Object>> noticeList = noticeService.vocNoticeList(request);
        return noticeList;
    }

    @RequestMapping(value = "/voc/notice/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authVocNoticeDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.vocNoticeDetail(request, noticeId);
        mView.setViewName("page/membership/vocNotice/noticeDetail");
        return mView;
    }

    @RequestMapping(value = "/voc/notice/input", method = RequestMethod.GET)
    public ModelAndView authVocNoticeInsertForm(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/vocNotice/noticeInsert");
        return mView;
    }

    @RequestMapping(value = "/voc/notice/input", method = RequestMethod.POST)
    public String authVocNoticeInsert(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.vocNoticeInsert(response, request, noticeDto);
        return "redirect:/voc/notice/"+noticeId;
    }

    @RequestMapping(value = "/voc/notice/modified/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authVocNoticeUpdateForm(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = noticeService.vocNoticeUpdateForm(request, noticeId);
        mView.addAllObjects(codeService.getCommonCode(NOTICE));
        mView.setViewName("page/membership/vocNotice/noticeUpdate");
        return mView;
    }

    @RequestMapping(value = "/voc/notice/modified/{noticeId}", method = RequestMethod.POST)
    public String autVochNoticeUpdate(HttpServletResponse response, HttpServletRequest request, @ModelAttribute NoticeDto noticeDto){
        int noticeId = noticeService.vocNoticeUpdate(response, request, noticeDto);
        return "redirect:/voc/notice/"+noticeId;
    }

    @RequestMapping(value = "/voc/notice/del/{noticeId}", method = RequestMethod.GET)
    public String authVocNoticeDel(HttpServletRequest request, @PathVariable int noticeId){
        noticeService.vocNoticeDel(request, noticeId);
        return "redirect:/voc/notice";
    }
}
