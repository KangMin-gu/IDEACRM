package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CampaignController {

    @RequestMapping(value = "/campaign", method = RequestMethod.GET)
    public ModelAndView campaignList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/campaign/campaignList");
        return mView;
    }
    @RequestMapping(value = "/campaign/insert", method = RequestMethod.GET)
    public ModelAndView campaignInsert(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/campaign/campaignInsert");
        return mView;
    }
    @RequestMapping(value = "/campaign/detail", method = RequestMethod.GET)
    public ModelAndView campaignDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/campaign/campaignDetail");
        return mView;
    }
}
