package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.dao.UploadDao;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
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
    @Autowired
    private UploadDao uploadDao;

    private final int USINGMENU = 3;//서비스 사용 메뉴 값은 3
    //화면 호출
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView authService(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/service/serviceList");
        return mView;
    }
    //footable에 바인딩할 LIst
    @RequestMapping(value="/service",method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authServiceSearchList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> serviceList = serviceService.serviceList(request);
        return serviceList;
    }
    // 서비스 상세 화면
    @RequestMapping(value="/service/{serviceNo}", method = RequestMethod.GET)
    public ModelAndView authServiceDetail(HttpServletRequest request, @PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        mView.addObject("fileInfo",uploadDao.fileInfo(serviceService.serviceDetail(request,serviceNo)));
        mView.addObject("serviceInfo",serviceService.serviceDetail(request,serviceNo));
        mView.addObject("rewardInfo",serviceService.rewardDetail(request,serviceNo));
        mView.addObject("ractInfo",serviceService.ractDetail(request,serviceNo));
        mView.addObject("product",serviceService.productDetail(request,serviceNo));

        mView.setViewName("page/service/serviceDetail");

        return mView;
    }
    // 서비스 수정 화면
    @RequestMapping(value="/service/modified/{serviceNo}",method=RequestMethod.GET)
    public ModelAndView authServiceUpdate(HttpServletRequest request,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        mView.addObject("serviceInfo",serviceService.serviceDetail(request,serviceNo));
        mView.addObject("rewardInfo",serviceService.rewardDetail(request,serviceNo));
        mView.addObject("ractInfo",serviceService.ractDetail(request,serviceNo));
        mView.addObject("product",serviceService.productDetail(request,serviceNo));

        List<ProductDto> productB = productService.getProductB(request);
        mView.addObject("productB",productB);
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));

        mView.setViewName("page/service/serviceUpdate");

        return mView;
    }
    // 서비스 수정
    @RequestMapping(value="/service/modified/{serviceNo}",method=RequestMethod.POST)
    public ModelAndView authServiceUpdateSet(HttpServletRequest request, HttpServletResponse response,@ModelAttribute ServiceDto serviceDto,@ModelAttribute RewardDto rewardDto, @ModelAttribute RactDto ractDto,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String resultServiceNo = serviceService.serviceInsertUpdate(request,response,serviceDto,rewardDto,ractDto);
        mView.setViewName("redirect:/service/"+resultServiceNo);
        return mView;
    }
    // 서비스 삭제
    @RequestMapping(value="/service/del/{serviceNo}",method=RequestMethod.POST)
    public ModelAndView authServiceDelete(HttpServletRequest request,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        serviceService.serviceDelete(request,serviceNo);
        mView.setViewName("page/service/serviceList");
        return mView;
    }

    // 서비스 추가 화면
    @RequestMapping(value = "/service/input", method = RequestMethod.GET)
    public ModelAndView authServiceInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        List<ProductDto> productB = productService.getProductB(request);
        mView.addObject("productB",productB);
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/service/serviceInsert");
        return mView;
    }
    // 서비스 추가
    @RequestMapping(value="/service/input",method=RequestMethod.POST)
    public ModelAndView authServiceInsertSet(HttpServletRequest request,  HttpServletResponse response,@ModelAttribute ServiceDto serviceDto, @ModelAttribute RewardDto rewardDto, @ModelAttribute RactDto ractDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String serviceNo = serviceService.serviceInsertUpdate(request, response,serviceDto,rewardDto,ractDto);
        mView.setViewName("redirect:/service/"+serviceNo);
        return mView;
    }

    // 처리결과 이력
    @RequestMapping(value="/service/tab/ract/{serviceNo}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authTabRactList(HttpServletRequest request,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> tabRactList = serviceService.ractList(request,serviceNo);
        return tabRactList;
    }
    // 이관 이력
    @RequestMapping(value="/service/tab/delivery/{serviceNo}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authTabConveyList(HttpServletRequest request,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> tabConveyList = serviceService.conveyList(request,serviceNo);
        return tabConveyList;
    }

    @RequestMapping(value="/service/{custNo}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authCustServiceTab(HttpServletRequest request, @PathVariable int custNo) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> custServiceTab = serviceService.serviceList(request);
        return custServiceTab;
    }

    @RequestMapping(value = "/service/delivery", method = RequestMethod.POST)
    @ResponseBody
    public int authDeliveryInsert(HttpServletRequest request, @ModelAttribute ServiceDeliveryDto serviceDeliveryDto) throws IOException, GeneralSecurityException {
        String serviceNo = serviceService.serviceDeliveryInsert(request,serviceDeliveryDto);
        return 0;
    }




    @RequestMapping(value="/service/calendar", method=RequestMethod.GET)
    public ModelAndView authSvCalendar(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = serviceService.serviceCalList(request);
        mView.setViewName("page/service/calendar/serviceCalendar");
        return mView;
    }

    @RequestMapping(value="/service/calendar/{serviceNo}", method=RequestMethod.GET)
    public ModelAndView authSvCalendarDetail(HttpServletRequest request,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addObject("serviceInfo",serviceService.serviceDetail(request, serviceNo));
        mView.addObject("rewardInfo",serviceService.rewardDetail(request, serviceNo));
        mView.addObject("ractInfo",serviceService.ractDetail(request, serviceNo));
        mView.addObject("product",serviceService.productDetail(request,serviceNo));
        mView.setViewName("page/service/calendar/pop/serviceCalendarPop");
        return mView;
    }


}

