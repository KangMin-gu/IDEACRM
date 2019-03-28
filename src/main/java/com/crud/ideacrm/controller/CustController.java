package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustController {

    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView custList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/custList");
        return mView;
    }

    @RequestMapping(value = "/custdetail", method = RequestMethod.GET)
    public ModelAndView custDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/custDetail");
        return mView;
    }

    @RequestMapping(value = "/custinsert", method = RequestMethod.GET)
    public ModelAndView custInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/cust/custInsert");
        return mView;
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> test(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> te = new HashMap<>();
        List<Map<String, Object>> test = new ArrayList<>();

        te.put("name","id");
        te.put("title","ID");

        test.add(te);

        return test;
    }

    @RequestMapping(value = "/b", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> testb(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> te = new HashMap<>();
        List<Map<String, Object>> testb = new ArrayList<>();

        te.put("name","id");
        te.put("title","ID");

        testb.add(te);

        return testb;
    }
}
