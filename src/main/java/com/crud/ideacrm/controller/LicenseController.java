package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.UseLicenseDto;
import com.crud.ideacrm.service.LicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
public class LicenseController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value = "/license/{siteId}", method = RequestMethod.GET)
    public ModelAndView deliveryList(HttpServletRequest request, @PathVariable String siteId){
        ModelAndView mView = new ModelAndView();
        mView.addObject("siteid",siteId);
        mView.setViewName("page/membership/master/license/license");
        return mView;
    }

    @RequestMapping(value="/company/license/{siteId}",method=RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> licenseDetail (HttpServletRequest request,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> siteLicenseDetail = licenseService.siteLicenseDetail(request,siteId);
        return siteLicenseDetail;
    }

    @RequestMapping(value="/company/license/input/{siteId}",method=RequestMethod.POST)
    public ModelAndView licenseInsert(HttpServletRequest request, @ModelAttribute UseLicenseDto useLicenseDto,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

        ModelAndView mView = new ModelAndView();
        licenseService.useLicenseInsert(request,useLicenseDto,siteId);
        mView.addObject("siteid",siteId);
        mView.setViewName("redirect:/license/"+siteId);

        return mView;
    }
}

