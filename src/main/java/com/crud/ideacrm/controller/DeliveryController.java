package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeliveryController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CodeService codeService;

    private final int USINGMENU = 3;//서비스 사용 메뉴 값은 3

    @RequestMapping(value="/service/delivery",method=RequestMethod.GET)
    public ModelAndView authServiceDelivery(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/service/serviceDeliveryList");
        return mView;
    }
}

