package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.*;

@Controller
public class CustController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CodeService codeService;
    @Autowired
    private CustService custService;

    private final int USINGMENU = 1;//고객의 사용 메뉴 값은 1 .

    //고객 리스트 기본 화면.
    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView authCustList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.setViewName("page/cust/custList");
        return mView;
    }
      //고객 리스트 - fooTable에 모델 객체 반환
    @RequestMapping(value = "/cust", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> custList = custService.custList(request);
        return custList;
    }

    //고객상세
    @RequestMapping(value = "/cust/{custno}", method = RequestMethod.GET)
    public ModelAndView authCustDetail(HttpServletRequest request, @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        System.out.println("@@@@@@custno@@@@@@@@@"+custno);
        ModelAndView mView = new ModelAndView();
        mView.addObject("custDetail",custService.custDetail(request,custno));
        mView.setViewName("page/cust/custDetail");
        return mView;
    }


    //고객수정
    @RequestMapping(value = "/cust/modified/{custno}", method = RequestMethod.GET)
    public ModelAndView authCustUpdateForm(HttpServletRequest request, @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {

        ModelAndView mView = new ModelAndView();
        mView.addObject("custDetail",custService.custDetail(request,custno));
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.setViewName("page/cust/custUpdate");
        return mView;
    }
    //고객 수정 실행
    @RequestMapping(value = "/cust/modified/{custno}", method = RequestMethod.POST)
    public String authCustUpdate(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto
            , @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        String custNo = custService.custUpdate(request,custDto,custDenyDto);
        return "redirect:/cust/"+custNo;
    }

    //고객 추가 form
    @RequestMapping(value = "/cust/input", method = RequestMethod.GET)
    public ModelAndView authCustInsertForm(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.setViewName("page/cust/custInsert");
        return mView;
    }

    //고객 추가 실행
    @RequestMapping(value = "/cust/input", method = RequestMethod.POST)
    public String authCustInsert(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        String custNo = custService.custinsert(request,custDto,custDenyDto);
        return "redirect:/cust/"+custNo;
    }

    //고객삭제
    @RequestMapping(value="/cust/del", method=RequestMethod.POST)
    public String authcustDelete(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        custService.custDelete(request);
        return "redirect:/cust";
    }


    //고객 상세 탭 메일리스트
    @RequestMapping(value = "/cust/tab/email", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustMailList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> mailList = custService.custEmailList(request);
        return mailList;
    }

    //고객 상세 탭 SMS리스트
    @RequestMapping(value = "/cust/tab/sms", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustSmsList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> smsList = custService.custSmsList(request);
        return smsList;
    }

    //고객 상세 탭 LMS리스트
    @RequestMapping(value = "/cust/tab/lms", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustLmsList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> lmsList = custService.custLmsList(request);
        return lmsList;
    }

    //고객 상세 탭 MMS리스트
    @RequestMapping(value = "/cust/tab/mms", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustMMSList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> mmsList = custService.custMmsList(request);
        return mmsList;
    }

    //고객 상세 탭 KAKAO리스트
    @RequestMapping(value = "/cust/tab/kakao", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustKakaoList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> kakaoList = custService.custKakaoList(request);
        return kakaoList;
    }

}
