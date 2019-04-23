package com.crud.ideacrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CampaignController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

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
