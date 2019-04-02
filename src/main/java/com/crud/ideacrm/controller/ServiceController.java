package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.RactDto;
import com.crud.ideacrm.dto.RewardDto;
import com.crud.ideacrm.dto.ServiceDto;
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
    //화면 호출
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView service(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceList");
        return mView;
    }
    //footable에 바인딩할 LIst
    @RequestMapping(value="/service/list",method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> serviceSearchList(HttpServletRequest request){
        List<Map<String,Object>> serviceList = serviceService.serviceList(request);
        return serviceList;
    }
    // 서비스 상세 화면
    @RequestMapping(value="/service/{serviceNo}", method = RequestMethod.GET)
    public ModelAndView serviceDetail(HttpServletRequest request, @PathVariable int serviceNo){
        ModelAndView mView = serviceService.serviceDetail(request,serviceNo);
        mView.setViewName("page/service/serviceDetail");
        return mView;
    }
    // 서비스 삭제(단일)
    @RequestMapping(value="/service/delete/{serviceNo}",method=RequestMethod.POST)
    public ModelAndView serviceDelete(HttpServletRequest request,@PathVariable int serviceNo){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("redirect:/service");
        return mView;
    }


    @RequestMapping(value = "/serviceinsert", method = RequestMethod.GET)
    public ModelAndView serviceInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceInsert");
        return mView;
    }

    @RequestMapping(value="/sevriceinsert",method=RequestMethod.POST)
    public ModelAndView serviceInsertSet(HttpServletRequest request, @ModelAttribute ServiceDto serviceDto, @ModelAttribute RewardDto rewardDto, @ModelAttribute RactDto ractDto){
        ModelAndView mView = new ModelAndView();
        int serviceNo = serviceService.serviceInsertUpdate(request,serviceDto,rewardDto,ractDto);
        mView.setViewName("redirect:/service/"+serviceNo);
        return mView;
    }

    @RequestMapping(value = "/service/calendar", method = RequestMethod.GET)
    public ModelAndView serviceCalendar(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/calendar/serviceCalendar");
        return mView;
    }
}
