package com.crud.ideacrm.controller;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.dto.ProductDto;
import com.crud.ideacrm.service.CodeService;
import com.crud.ideacrm.service.CustService;
import com.crud.ideacrm.service.ProductService;
import com.crud.ideacrm.service.VocService;
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
public class VocController {

    @Autowired
    private CustService custService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private VocService vocService;

    private final int USINGMENU = 3;//서비스 사용 메뉴 값은 3

    @RequestMapping(value = "/voc/dashboard", method = RequestMethod.GET)
    public ModelAndView authVocList(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocDashboard");
        return mView;
    }


    @RequestMapping(value = "/voc", method = RequestMethod.GET)
    public ModelAndView authVocDetail(HttpServletRequest request){
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
    public ModelAndView authVocstisfied(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocSatisfied");
        return mView;
    }

    @RequestMapping(value = "/voc/custsearch", method = RequestMethod.GET)
    public ModelAndView authVocCustSearchPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        mView.setViewName("page/voc/pop/custSearchPop");
        return mView;
    }
    @RequestMapping(value="/voc/custsearch", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> authVocCustSearch(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);
        List<Map<String,Object>> custSearchList = custService.custList(param);

        return custSearchList;
    }

    //고객 팝업 클릭 된 고객의 상세정보
    @RequestMapping(value="/voc/cust/{custno}", method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> authVocCustDetail(HttpServletRequest request, @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custno);
        custDto.setSiteid(siteId);
        Map<String,Object> custDetail = custService.custDetail(custDto);
        return custDetail;
    }


    @RequestMapping(value = "/voc/custdetail/{custNo}", method = RequestMethod.GET)
    public ModelAndView authVocCustDetailPop(HttpServletRequest request, @PathVariable String custNo) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        CustDto custDto = new CustDto();
        custDto.setCustno(custNo);
        custDto.setSiteid(siteId);
        ModelAndView mView = new ModelAndView();
        mView.addObject("custDetail",custService.custDetail(custDto));
        mView.setViewName("page/voc/pop/custDetailPop");
        return mView;
    }

    //voc 고객 수정 실행
    @RequestMapping(value = "/voc/cust/modified/{custno}", method = RequestMethod.POST)
    @ResponseBody
    public int authVocCustUpdate(HttpServletRequest request, @ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto
            , @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);
        int res = vocService.vocCustUpdate(custDto,custDenyDto);
        return res;
    }

    @RequestMapping(value = "/voc/sms", method = RequestMethod.GET)
    public ModelAndView authVocSmsPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/smsPop");
        return mView;
    }

    @RequestMapping(value = "/voc/kakao", method = RequestMethod.GET)
    public ModelAndView authVocKakaoPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/popup/kakaoPop");
        return mView;
    }

    @RequestMapping(value = "/voc/email", method = RequestMethod.GET)
    public ModelAndView authVocEmailPop(HttpServletRequest request){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/pop/emailPop");
        return mView;
    }
}
