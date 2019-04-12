package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.dto.ProductDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import com.crud.ideacrm.service.ProductService;
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
public class VocController {

    @Autowired
    private CustService custService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private ProductService productService;

    private final int USINGMENU = 3;//서비스 사용 메뉴 값은 3

    @RequestMapping(value = "/voc/dashboard", method = RequestMethod.GET)
    public ModelAndView vocList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocDashboard");
        return mView;
    }


    @RequestMapping(value = "/voc", method = RequestMethod.GET)
    public ModelAndView vocDetail(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId));
        List<ProductDto> productB = productService.getProductB(request);
        mView.addObject("productB",productB);
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
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        mView.addAllObjects( codeService.getCommonCode(USINGMENU));
        mView.addAllObjects( codeService.getCustomCode(USINGMENU,siteId));
        mView.setViewName("page/voc/pop/custSearchPop");
        return mView;
    }
    @RequestMapping(value="/voc/custsearch", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> vocCsutSearch(HttpServletRequest request){
        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);
        List<Map<String,Object>> custSearchList = custService.custList(param);

        return custSearchList;
    }

    @RequestMapping(value = "/voc/custdetail/{custNo}", method = RequestMethod.GET)
    public ModelAndView vocCustDetailPop(HttpServletRequest request, @PathVariable int custNo){
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custNo);
        custDto.setSiteid(siteId);
        ModelAndView mView = new ModelAndView();
        mView.addObject("custDetail",custService.custDetail(custDto));
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
