package com.crud.ideacrm.controller;

import com.crud.ideacrm.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CodeController {
    
    @Autowired
    private CodeService codeService;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView Test(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();


        return mView;
    }
}
