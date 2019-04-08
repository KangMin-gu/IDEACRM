package com.crud.ideacrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class VocController {

    @RequestMapping(value = "/voc/dashboard", method = RequestMethod.GET)
    public ModelAndView vocList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocDashboard");
        return mView;
    }


    @RequestMapping(value = "/voc", method = RequestMethod.GET)
    public ModelAndView vocDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocIndex");
        return mView;
    }

    @RequestMapping(value = "/voc/satisfied", method = RequestMethod.GET)
    public ModelAndView vocstisfied(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocSatisfied");
        return mView;
    }

    @RequestMapping(value = "/voc/custsearch", method = RequestMethod.GET)
    public ModelAndView vocCustSearchPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/pop/custSearchPop");
        return mView;
    }

    @RequestMapping(value = "/voc/custdetail", method = RequestMethod.GET)
    public ModelAndView vocCustDetailPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/pop/custDetailPop");
        return mView;
    }

    @RequestMapping(value = "/voc/sms", method = RequestMethod.GET)
    public ModelAndView vocSmsPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/smsPop");
        return mView;
    }

    @RequestMapping(value = "/voc/kakao", method = RequestMethod.GET)
    public ModelAndView vocKakaoPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/kakaoPop");
        return mView;
    }

    @RequestMapping(value = "/voc/email", method = RequestMethod.GET)
    public ModelAndView vocEmailPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/pop/emailPop");
        return mView;
    }
}
