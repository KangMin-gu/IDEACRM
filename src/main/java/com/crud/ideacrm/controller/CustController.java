package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
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
import java.util.*;

@Controller
public class CustController {

    @Autowired
    CodeService codeService;
    @Autowired
    CustService custService;
    @Autowired
    ServiceService serviceService;
    private final int USINGMENU = 1;//고객의 사용 메뉴 값은 1 .

    //고객 리스트 기본 화면.test
    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView authCustList(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId) );
        mView.setViewName("page/cust/custList");

        return mView;
    }
    //고객 리스트 - fooTable에 모델 객체 반환
    @RequestMapping(value = "/cust", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustList(HttpServletRequest request){
        Map<String,Object> searchPrm = new ParameterUtil().searchParam(request);
        List<Map<String, Object>> custList = custService.custList(searchPrm);
        return custList;
    }
    //고객상세
    @RequestMapping(value = "/cust/{custno}", method = RequestMethod.GET)
    public ModelAndView authCustDetail(HttpServletRequest request, @PathVariable int custno){
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
    public ModelAndView authCustUpdateForm(HttpServletRequest request, @PathVariable int custno){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custno);
        custDto.setSiteid(siteId);

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId) );
        mView.addObject("custUpdate",custService.custDetail(custDto));
        mView.setViewName("page/cust/custUpdate");
        return mView;
    }
    //고객 수정 실행
    @RequestMapping(value = "/cust/modified/{custno}", method = RequestMethod.POST)
    public String authCustUpdate(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto
            , @PathVariable int custno) {
        System.out.println("kkkkkkkkkkkk@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);
        int custNo = custService.custUpdate(custDto,custDenyDto);
        return "redirect:/cust/"+custNo;
    }

    //고객 추가 form
    @RequestMapping(value = "/cust/input", method = RequestMethod.GET)
    public ModelAndView authCustInsertForm(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU) );
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId) );
        mView.setViewName("page/cust/custInsert");
        return mView;
    }
    //고객 추가 실행
    @RequestMapping(value = "/cust/input", method = RequestMethod.POST)
    public String authCustInsert(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);custDto.setReguser(userNo);
        custDenyDto.setReguser(userNo);
        int custNo = custService.custinsert(custDto,custDenyDto);
        return "redirect:/cust/"+custNo;
    }

    //고객삭제
    @RequestMapping(value="/cust/del", method=RequestMethod.POST)
    public String authcustDelete(HttpServletRequest request) {
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
    public List<Map<String,Object>> authTabRactList(HttpServletRequest request,@PathVariable int custno){
        return serviceService.serviceList(request);
    }
}
