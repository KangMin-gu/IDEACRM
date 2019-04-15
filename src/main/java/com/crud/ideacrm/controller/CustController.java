package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.CrudCommonUtil; 
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import com.crud.ideacrm.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.util.*;

@Controller
public class CustController {

    @Autowired
    CodeService codeService;
    @Autowired
    CustService custService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    CrudCommonUtil commonUtil;

    private final int USINGMENU = 1;//고객의 사용 메뉴 값은 1 .

    //고객 리스트 기본 화면.testd
    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView authCustList(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

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
        return custService.custList(commonUtil.searchParam(request));
    }

    //고객상세
    @RequestMapping(value = "/cust/{custno}", method = RequestMethod.GET)
    public ModelAndView authCustDetail(HttpServletRequest request, @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custno);
        custDto.setSiteid(siteId);
        ModelAndView mView = new ModelAndView();
        mView.addObject("custDetail",custService.custDetail(custDto));
        mView.setViewName("page/cust/custDetail");
        return mView;
    }
    //고객수정
    @RequestMapping(value = "/cust/modified/{custno}", method = RequestMethod.GET)
    public ModelAndView authCustUpdateForm(HttpServletRequest request, @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custno);
        custDto.setSiteid(siteId);

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.addObject("custUpdate",custService.custDetail(custDto));
        mView.setViewName("page/cust/custUpdate");
        return mView;
    }
    //고객 수정 실행
    @RequestMapping(value = "/cust/modified/{custno}", method = RequestMethod.POST)
    public String authCustUpdate(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto
            , @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);
        String custNo = custService.custUpdate(custDto,custDenyDto);

        return "redirect:/cust/"+custNo;
    }

    //고객 추가 form
    @RequestMapping(value = "/cust/input", method = RequestMethod.GET)
    public ModelAndView authCustInsertForm(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request) );
        mView.setViewName("page/cust/custInsert");
        return mView;
    }
    //고객 추가 실행
    @RequestMapping(value = "/cust/input", method = RequestMethod.POST)
    public String authCustInsert(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);custDto.setReguser(userNo);
        custDenyDto.setReguser(userNo);
        String custNo = custService.custinsert(custDto,custDenyDto);
        return "redirect:/cust/"+custNo;
    }

    //고객삭제
    @RequestMapping(value="/cust/del", method=RequestMethod.POST)
    public String authcustDelete(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        CustDto custDto=new CustDto();
        custDto.setSiteid(siteid);
        custDto.setEdituser(userno);
        String[] custnoArr = request.getParameterValues("custno");
        custService.custDelete(custDto,custnoArr);
        return "redirect:/cust";
    }

    //고객상세 서비스 탭
    @RequestMapping(value="/cust/tab/service/{custno}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authTabRactList(HttpServletRequest request,@PathVariable String custno){
        return serviceService.serviceList(request);
    }


    @RequestMapping(value="/testtt",method=RequestMethod.GET)
    public ModelAndView testtt(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        uri = URLDecoder.decode(uri, "UTF-8");
        System.out.println(uri);
        String abcd = commonUtil.encoding("abcd");
        commonUtil.searchParam(request);
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/test");
        mView.addObject("abcd",abcd);
        return mView;
    }
}
