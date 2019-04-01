package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.*;

@Controller
public class CustController {

    @Autowired
    CodeService codeService;
    @Autowired
    CustService custService;

    @RequestMapping(value = "/cust", method = RequestMethod.GET)
    public ModelAndView custList(HttpServletRequest request){
        //Map<String,Object> searchPrm = new HashMap<String,Object>();
        //searchPrm.put("siteid",1);
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(codeService.getCommonCode("CUST",siteid));//구분값 string으로 할지 int로 할지 선택 필요.
        mView.addAllObjects(codeService.getCustomCode("CUST",siteid));//구분값 string으로 할지 int로 할지 선택 필요.
        //mView.addObject(custService.custList(searchPrm));
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

    @RequestMapping(value = "/w3werwerwer", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> test(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        List<Map<String, Object>> test = new ArrayList<>();
        Map<String, Object> te = new HashMap<>();
        te.put("name","CUSTNO");
        te.put("title","고객번호");

        Map<String, Object> te2 = new HashMap<>();
        te2.put("name","CUSTNAME");
        te2.put("title","고객명");

        test.add(te);
        test.add(te2);
        return test;
    }

    @RequestMapping(value = "/cust", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> testb(HttpServletRequest request){

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

        searchPrm.put("siteid",1);
        List<Map<String, Object>> custList = custService.custList(searchPrm);

        return custList;
    }
}
