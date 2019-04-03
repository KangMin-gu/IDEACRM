package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.CodeDto;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class CustController {

    @Autowired
    CodeService codeService;
    @Autowired
    CustService custService;
    private final int USINGMENU = 1;//고객의 사용 메뉴 값은 1

    //고객 리스트 기본 화면.
    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView authCustList(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCode(USINGMENU,siteId) );
        mView.setViewName("page/cust/custList");

        return mView;
    }
    //고객 리스트 - fooTable에 모델 객체 반환
    @RequestMapping(value = "/cust", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> authGetCustList(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        Map<String, Object> searchPrm = new HashMap<>();
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = (String)params.nextElement();
            String value = request.getParameter(name);
            if(value == "") {
                value = null;
            }
            searchPrm.put(name, value);
        }
        searchPrm.put("siteid",siteId);
        List<Map<String, Object>> custList = custService.custList(searchPrm);
        return custList;
    }
    //고객상세
    @RequestMapping(value = "/custdetail/{custno}", method = RequestMethod.GET)
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
    //고객 추가 form
    @RequestMapping(value = "/custinsert", method = RequestMethod.GET)
    public ModelAndView authCustInsertForm(HttpServletRequest request){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(codeService.getCode(USINGMENU,siteId));
        mView.setViewName("page/cust/custInsert");
        return mView;
    }
    //고객 추가 실행
    @RequestMapping(value = "/custinsert", method = RequestMethod.POST)
    public String authCustInsert(HttpServletRequest request,@ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);custDto.setReguser(userNo);
        custDenyDto.setReguser(userNo);
        int custNo = custService.custinsert(custDto,custDenyDto);
        return "redirect:/custdetail/"+custNo;
    }
}
