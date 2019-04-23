package com.crud.ideacrm.controller;

import com.crud.ideacrm.dto.CodeDto;
import com.crud.ideacrm.service.CodeService;
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
public class CodeController {

    @Autowired
    private CodeService codeService;
    @Autowired
    private LicenseService licenseService;

    private final static int USINGMENU = 0;

    // 상위코드의 GRPCODE, CODEVAL로 하위 코드들 가져오기
    @RequestMapping(value="/company/code/upper", method=RequestMethod.GET)
    @ResponseBody
    public List<CodeDto> authGetUpperCodeList(HttpServletRequest request){
        List<CodeDto> upperCode = codeService.getUpperCodeGrp(request);
        return upperCode;
    }

    @RequestMapping(value = "/common/code", method = RequestMethod.GET)
    public ModelAndView authCommonCodeList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.addObject("siteLicense",licenseService.licenseList(request));
        mView.addObject("allLicense",licenseService.allLicenseList());
        mView.setViewName("page/membership/manager/code/codeList");
        return mView;
    }
    @RequestMapping(value = "/company/code", method = RequestMethod.GET)
    public ModelAndView authCodeList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.addObject("siteLicense",licenseService.licenseList(request));
        mView.addObject("allLicense",licenseService.allLicenseList());
        mView.setViewName("page/membership/manager/code/codeList");
        return mView;
    }

    @RequestMapping(value="/company/code/{siteId}",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authCompanyCode(HttpServletRequest request,@PathVariable String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> companyCodeList = codeService.codeList(request,siteId);
        return companyCodeList;
    }

    @RequestMapping(value="/company/code/{codeNo}",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> authCompanyCodeDetail(HttpServletRequest request,@PathVariable String codeNo) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> companyCodeDetail = codeService.codeDetail(request,codeNo);
        return companyCodeDetail;
    }

    @RequestMapping(value="/company/code/input",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> authCodeInsert(HttpServletRequest request, @ModelAttribute CodeDto codeDto) throws UnsupportedEncodingException, GeneralSecurityException {

        String codeNo = codeService.codeInsert(request,codeDto);
        Map<String,Object> codeDetail = codeService.codeDetail(request,codeNo);

        return codeDetail;
    }

    @RequestMapping(value="/company/code/modified/{codeNo}",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> authCodeUpdate(HttpServletRequest request, @ModelAttribute CodeDto codeDto) throws UnsupportedEncodingException, GeneralSecurityException {
        String codeNo = codeService.codeUpdate(request,codeDto);
        Map<String,Object> codeDetail = codeService.codeDetail(request,codeNo);
        return codeDetail;
    }

    @RequestMapping(value="/company/code/del/{codeNo}",method=RequestMethod.POST)
    @ResponseBody
    public int authCodeDelete(HttpServletRequest request, @PathVariable String codeNo) throws UnsupportedEncodingException, GeneralSecurityException {
        codeService.codeDelete(request,codeNo);
        return 0;
    }

}
