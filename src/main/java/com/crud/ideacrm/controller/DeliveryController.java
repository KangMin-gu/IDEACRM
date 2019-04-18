package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.ServiceDeliveryDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DeliveryController {

    @RequestMapping(value = "/service/delivery", method = RequestMethod.GET)
    public ModelAndView deliveryList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/service/delivery/deliveryList");
        return mView;
    }
}

