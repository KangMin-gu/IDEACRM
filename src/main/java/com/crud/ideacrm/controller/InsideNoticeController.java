package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.InsideNoticeDto;
import com.crud.ideacrm.service.InsideNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class InsideNoticeController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private InsideNoticeService isns;

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
    //보낸통지함
    @RequestMapping(value = "/outbox", method = RequestMethod.GET)
    public ModelAndView authOutboxList(HttpServletRequest request){
        ModelAndView mView = isns.outboxList(request);
        mView.setViewName("page/membership/insideNotice/outBox");
        return mView;
    }
    //보낸통지검색
    @RequestMapping(value = "/outbox", method = RequestMethod.POST)
    public ModelAndView authoutboxListSearch(HttpServletRequest request){
        ModelAndView mView = isns.outboxList(request);
        mView.setViewName("page/membership/insideNotice/outBox");
        return mView;
    }

    //휴지통
    @RequestMapping(value = "/trashbox", method = RequestMethod.GET)
    public ModelAndView authtrashboxList(HttpServletRequest request){
        ModelAndView mView = isns.trashbox(request);
        mView.setViewName("page/membership/insideNotice/trashBox");
        return mView;
    }

    //휴지통검색
    @RequestMapping(value = "/trashbox", method = RequestMethod.POST)
    public ModelAndView authtrashboxListSearch(HttpServletRequest request){
        ModelAndView mView = isns.trashbox(request);
        mView.setViewName("page/membership/insideNotice/trashBox");
        return mView;
    }

    //삭제
    @RequestMapping(value="/delchk", method=RequestMethod.GET)
    @ResponseBody
    public void authnoteDeleteChk(HttpServletRequest request, @RequestParam(value="checkArr[]") List<Integer> noticeid) {
        isns.noteDeleteChk(request, noticeid);
    }

    //보관함 되돌리기
    @RequestMapping(value="/returnchk", method=RequestMethod.GET)
    @ResponseBody
    public void authnoteReturnChk(HttpServletRequest request, @RequestParam(value="checkArr[]") List<Integer> noticeid) {
        isns.noteReturnChk(request, noticeid);	//return으로 수정
    }

    //메일발송폼
    @RequestMapping(value = "/compose", method = RequestMethod.GET)
    public ModelAndView authsendForm(HttpServletRequest request){
        ModelAndView mView = isns.composeData(request);
        mView.setViewName("page/membership/insideNotice/sendForm");
        return mView;
    }

    //메일발송
    @RequestMapping(value = "/compose", method = RequestMethod.POST)
    public String authsend(HttpServletResponse response, HttpServletRequest request, @ModelAttribute InsideNoticeDto insDto){
        int noticeId = isns.send(response, request, insDto);
        return "redirect:/inbox/view/"+noticeId;
    }


    //받은메일상세보기
    @RequestMapping(value = "/inbox/view/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authboxDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = isns.boxDetail(request, noticeId);
        mView.setViewName("page/membership/insideNotice/boxDetail");
        return mView;
    }

    //보낸메일상세보기
    @RequestMapping(value = "/outbox/view/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authOutBoxDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = isns.outBoxDetail(request, noticeId);
        mView.setViewName("page/membership/insideNotice/boxDetail");
        return mView;
    }

    //휴지통메일상세보기
    @RequestMapping(value = "/trashbox/view/{noticeId}", method = RequestMethod.GET)
    public ModelAndView authTrashBoxDetail(HttpServletRequest request, @PathVariable int noticeId){
        ModelAndView mView = isns.boxDetail(request, noticeId);
        mView.setViewName("page/membership/insideNotice/boxDetail");
        mView.addObject("location","trash");
        return mView;
    }

    //휴지통버리기
    @RequestMapping(value = "/trashin", method = RequestMethod.GET)
    public String authTrashIn(HttpServletRequest request){
        isns.trashIn(request);
        return "redirect:/inbox";
    }

    //휴지통버리기
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String authDel(HttpServletRequest request){
        isns.del(request);
        return "redirect:/trashbox";
    }
}
