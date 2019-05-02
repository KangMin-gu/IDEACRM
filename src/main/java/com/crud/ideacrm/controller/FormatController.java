package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.FormatDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.FormatService;
import com.crud.ideacrm.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
public class FormatController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private FormatService formatService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private LicenseService licenseService;

    private final int USINGMENU = 0;//서비스 사용 메뉴 값은 3

    @RequestMapping(value = "/company/format", method = RequestMethod.GET)
    public ModelAndView authFormat(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.addObject("license",licenseService.siteLicenseList(request));
        mView.setViewName("page/membership/manager/format/formatList");
        return mView;
    }

    @RequestMapping(value="/company/format",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authFormatList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> formatList = formatService.formatList(request);
        return formatList;
    }

    @RequestMapping(value = "/company/format/{formatNo}", method = RequestMethod.GET)
    public ModelAndView authFormatDetail(HttpServletRequest request, @PathVariable String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addObject("formatInfo",formatService.formatDetail(request,formatNo));
        mView.setViewName("page/membership/manager/format/formatDetail");
        return mView;
    }

    @RequestMapping(value = "/company/format/input", method = RequestMethod.GET)
    public ModelAndView authFormatInsert(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        mView.addObject("license",licenseService.siteLicenseList(request));
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));

        mView.setViewName("page/membership/manager/format/formatInsert");
        return mView;
    }

    @RequestMapping(value="/company/format/input",method=RequestMethod.POST)
    public ModelAndView authFormatInsertSet(HttpServletRequest request, @ModelAttribute FormatDto formatDto) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String formatNo = formatService.formatInsert(request,formatDto);

        mView.setViewName("redirect:/company/format/"+formatNo);
        return mView;
    }

    @RequestMapping(value = "/company/format/modified/{formatNo}", method = RequestMethod.GET)
    public ModelAndView authFormatUpdate(HttpServletRequest request,@PathVariable String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();

        mView.addObject("license",licenseService.siteLicenseList(request));
        mView.addObject("formatInfo",formatService.formatDetail(request,formatNo));
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));

        mView.setViewName("page/membership/manager/format/formatUpdate");
        return mView;
    }

    @RequestMapping(value="/company/format/modified/{formatNo}",method=RequestMethod.POST)
    public ModelAndView authFormatUpdateSet(HttpServletRequest request, @ModelAttribute FormatDto formatDto,@PathVariable String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        formatService.formatUpdate(request,formatDto,formatNo);

        mView.setViewName("redirect:/company/format/"+formatNo);
        return mView;
    }

    @RequestMapping(value="/company/format/del/{formatNo}",method=RequestMethod.POST)
    public String authFormatDelete(HttpServletRequest request,@PathVariable String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {

        formatService.formatDelete(request,formatNo);

        return "redirect:/company/format";
    }

    @RequestMapping(value="/formatdesc",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> authFormatdesc(HttpServletRequest request, @RequestParam int formatnum){
        Map<String, Object> formatdesc = formatService.formatDesc(formatnum);
        return formatdesc;
    }

}
