package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.ClientDao;
import com.crud.ideacrm.service.ClientService;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.service.CustService;
import com.crud.ideacrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    //담당자팝업
    @RequestMapping(value="/popowner", method= RequestMethod.GET)
    public ModelAndView authPopUser(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/managerPop");
        return mView;
    }
    @RequestMapping(value="/popowner", method= RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authPopUserList(HttpServletRequest request) {
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
    public List<Map<String,Object>> authPopCustList(HttpServletRequest request){
        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> custList = custService.custList(param);
        return custList;
    }
    @RequestMapping(value="/popcust/{custNo}",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> authPopCustDetail(HttpServletRequest request, @PathVariable int custNo){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custNo);
        custDto.setSiteid(siteId);
        Map<String,Object> custDetail = custService.custDetail(custDto);
        return custDetail;
    }

    //담당자팝업
    @RequestMapping(value="/popclient", method= RequestMethod.GET)
    public ModelAndView authPopClient(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/clientPop");
        return mView;
    }
    @RequestMapping(value="/popclient", method= RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authPopClientList(HttpServletRequest request) {
        Map<String,Object> searchPrm = new ParameterUtil().searchParam(request);
        return clientService.clientList(searchPrm);
    }

}
