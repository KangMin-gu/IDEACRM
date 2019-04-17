package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LicenseController {

    //라이센스 팝업
    @RequestMapping(value = "/license", method = RequestMethod.GET)
    public ModelAndView deliveryList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/license/license");
        return mView;
    }

    @RequestMapping(value = "/license/{siteId}", method = RequestMethod.GET)
    public ModelAndView deliveryList(HttpServletRequest request, @PathVariable String siteId){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/membership/master/license/license");
        return mView;
    }


}

