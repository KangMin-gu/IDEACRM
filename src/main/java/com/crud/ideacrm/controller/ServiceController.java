package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView service(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceList");
        return mView;
    }

    @RequestMapping(value="/service/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> serviceList(HttpServletRequest request){
        List<Map<String,Object>> serviceList = serviceService.serviceList(request);
        return serviceList;
    }
    @RequestMapping(value="/service/list",method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> serviceSearchList(HttpServletRequest request){
        List<Map<String,Object>> serviceList = serviceService.serviceList(request);
        return serviceList;
    }
/*
    @RequestMapping(value="/service/{serviceNo}", method = RequestMethod.GET)
    public ModelAndView serviceDetail(HttpServletRequest request, @PathVariable int serviceNo){

        ModelAndView mView = serviceService.serviceDetail(request,serviceNo);
        return mView;
    }
*/
    @RequestMapping(value = "/servicedetail", method = RequestMethod.GET)
    public ModelAndView serviceDetail2(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceDetail");
        return mView;
    }

    @RequestMapping(value = "/serviceinsert", method = RequestMethod.GET)
    public ModelAndView serviceInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/serviceInsert");
        return mView;
    }

    @RequestMapping(value = "/service/calendar", method = RequestMethod.GET)
    public ModelAndView serviceCalendar(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/calendar/serviceCalendar");
        return mView;
    }
}
