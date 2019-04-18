package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.UseLicenseDto;
import com.crud.ideacrm.service.LicenseService;
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
    @ResponseBody
    public int licenseInsert(HttpServletRequest request, @ModelAttribute UseLicenseDto useLicenseDto){

        return 0;
    }


}

