package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;


@Controller
public class PopController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustService custService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private SendService sendService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private ServiceService serviceService;

    private final int USINGMENU = 0;//서비스 사용 메뉴 값은 3
    private final int SERVICEMENU = 3;
    //담당자팝업
    @RequestMapping(value="/popuser", method= RequestMethod.GET)
    public ModelAndView authPopUser(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,request));
        mView.setViewName("page/popup/managerPop");
        return mView;
    }
    @RequestMapping(value="/popuser", method= RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authPopUserList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String,Object>> userList = userService.userList(request);
        return userList;
    }

    // 고객팝업
    @RequestMapping(value="/popcust",method=RequestMethod.GET)
    public ModelAndView authPopCust(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/custPop");
        return mView;
    }
    @RequestMapping(value="/popcust",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authPopCustList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        return custService.custList(request);
    }

    @RequestMapping(value="/popcust/{custNo}",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> authPopCustDetail(HttpServletRequest request, @PathVariable String custNo) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String,Object> custDetail = custService.custDetail(request,custNo);
        return custDetail;
    }

    //담당자팝업
    @RequestMapping(value="/popaccount", method= RequestMethod.GET)
    public ModelAndView authPopClient(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/clientPop");
        return mView;
    }

    @RequestMapping(value="/popaccount", method= RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authPopClientList(HttpServletRequest request) {
        Map<String,Object> searchPrm = new ParameterUtil().searchParam(request);
        return clientService.clientList(searchPrm);
    }

    @RequestMapping(value = "/popsms", method = RequestMethod.GET)
    public ModelAndView authSmsPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/smsPop");
        return mView;
    }

    @RequestMapping(value = "/popsms", method = RequestMethod.POST)
    public void authSmsPopSend(HttpServletRequest request){
        sendService.sendSms(request);
    }

    @RequestMapping(value = "/popkakao", method = RequestMethod.GET)
    public ModelAndView authKakaoPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/kakaoPop");
        return mView;
    }

    @RequestMapping(value = "/popemail", method = RequestMethod.GET)
    public ModelAndView authEmailPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/emailPop");
        return mView;
    }
    @RequestMapping(value="/popuppercode",method=RequestMethod.GET)
    public ModelAndView authCodeUpperPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/codePop");
        return mView;
    }
    @RequestMapping(value="/popservicedelivery/{serviceNo}",method=RequestMethod.GET)
    public ModelAndView authServiceDeliveryPop(HttpServletRequest request,@PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addObject("serviceInfo",serviceService.serviceDetail(request,serviceNo));
        mView.addAllObjects( codeService.getCommonCode(SERVICEMENU));
        mView.addAllObjects( codeService.getCustomCode(SERVICEMENU,request));
        mView.setViewName("page/service/pop/serviceDeliveryPop");
        return mView;
    }

}
