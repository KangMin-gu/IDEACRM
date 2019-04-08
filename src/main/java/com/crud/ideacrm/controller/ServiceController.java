package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.*;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import com.crud.ideacrm.service.ProductService;
import com.crud.ideacrm.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private ProductService productService;

    private final int USINGMENU = 3;//서비스 사용 메뉴 값은 3
    //화면 호출
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView authService(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId));
        mView.setViewName("page/service/serviceList");
        return mView;
    }
    //footable에 바인딩할 LIst
    @RequestMapping(value="/service/list",method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authServiceSearchList(HttpServletRequest request){
        List<Map<String,Object>> serviceList = serviceService.serviceList(request);
        return serviceList;
    }
    // 서비스 상세 화면
    @RequestMapping(value="/service/{serviceNo}", method = RequestMethod.GET)
    public ModelAndView authServiceDetail(HttpServletRequest request, @PathVariable int serviceNo){
        ModelAndView mView = serviceService.serviceDetail(request,serviceNo);
        mView.setViewName("page/service/serviceDetail");

        return mView;
    }
    // 서비스 수정 화면
    @RequestMapping(value="/serviceupdate/{serviceNo}",method=RequestMethod.GET)
    public ModelAndView authServiceUpdate(HttpServletRequest request,@PathVariable int serviceNo){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        ModelAndView mView = serviceService.serviceDetail(request,serviceNo);
        List<ProductDto> productB = productService.getProductB(request);
        mView.addObject("productB",productB);
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId));
        mView.setViewName("page/service/serviceUpdate");

        return mView;
    }
    // 서비스 수정
    @RequestMapping(value="/serviceupdate/{serviceNo}",method=RequestMethod.POST)
    public ModelAndView authServiceUpdateSet(HttpServletRequest request,@ModelAttribute ServiceDto serviceDto,@ModelAttribute RewardDto rewardDto, @ModelAttribute RactDto ractDto,@PathVariable int serviceNo){
        ModelAndView mView = new ModelAndView();
        int resultServiceNo = serviceService.serviceInsertUpdate(request,serviceDto,rewardDto,ractDto);
        mView.setViewName("redirect:/service/"+resultServiceNo);
        return mView;
    }
    // 서비스 삭제
    @RequestMapping(value="/servicedelete/{serviceNo}",method=RequestMethod.POST)
    public ModelAndView authServiceDelete(HttpServletRequest request,@PathVariable int serviceNo){
        ModelAndView mView = new ModelAndView();
        serviceService.serviceDelete(request,serviceNo);
        mView.setViewName("page/service/serviceList");
        return mView;
    }

    // 서비스 추가 화면
    @RequestMapping(value = "/serviceinsert", method = RequestMethod.GET)
    public ModelAndView authServiceInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        List<ProductDto> productB = productService.getProductB(request);
        mView.addObject("productB",productB);
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId));
        mView.setViewName("page/service/serviceInsert");
        return mView;
    }
    // 서비스 추가
    @RequestMapping(value="/serviceinsert",method=RequestMethod.POST)
    public ModelAndView authServiceInsertSet(HttpServletRequest request, @ModelAttribute ServiceDto serviceDto, @ModelAttribute RewardDto rewardDto, @ModelAttribute RactDto ractDto){
        ModelAndView mView = new ModelAndView();
        int serviceNo = serviceService.serviceInsertUpdate(request,serviceDto,rewardDto,ractDto);
        mView.setViewName("redirect:/service/"+serviceNo);
        return mView;
    }

    @RequestMapping(value = "/service/calendar", method = RequestMethod.GET)
    public ModelAndView authServiceCalendar(HttpServletRequest request){//123
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/calendar/serviceCalendar");
        return mView;
    }
    // 처리결과 이력
    @RequestMapping(value="/tab/ract/{serviceNo}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authTabRactList(HttpServletRequest request,@PathVariable int serviceNo){
        List<Map<String,Object>> tabRactList = serviceService.ractList(request,serviceNo);
        return tabRactList;
    }
    // 이관 이력
    @RequestMapping(value="/tab/convey/{serviceNo}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authTabConveyList(HttpServletRequest request,@PathVariable int serviceNo){
        List<Map<String,Object>> tabConveyList = serviceService.conveyList(request,serviceNo);
        return tabConveyList;
    }
}
