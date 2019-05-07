package com.crud.ideacrm.controller;


import com.crud.ideacrm.crud.dao.UploadDao;
import com.crud.ideacrm.dto.*;
import com.crud.ideacrm.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
public class VocController {
    private static final Logger logger = LoggerFactory.getLogger(VocController.class);

    @Autowired
    private CustService custService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private VocService vocService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private SendService sendService;
    @Autowired
    private UploadDao uploadDao;
    @Autowired
    private FormatService formatService;

    private final int USINGMENU = 3;//  서비스 사용 메뉴 값은 3

    //voc 대쉬보드
    @RequestMapping(value = "/voc/dashboard", method = RequestMethod.GET)
    public ModelAndView authvocList(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocDashboard");
        return mView;
    }

    //voc cti 페이지
    @RequestMapping(value = "/voc", method = RequestMethod.GET)
    public ModelAndView vocDetail(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int sendType = 4; // 상담템플릿 서식 값
        int useMenu = 5; // voc 메뉴 서식 값
        List<Map<String, Object>> formList = vocService.getVocSendForm(request, sendType, useMenu);

        mView.addObject("formList", formList);
        mView.addAllObjects(codeService.getCommonCode(USINGMENU));
        mView.addAllObjects(codeService.getCustomCode(USINGMENU, request));
        List<ProductDto> productB = productService.getProductB(request);
        mView.addAllObjects(siteService.ctiDetail(request));
        mView.addObject("productB", productB);
        mView.setViewName("page/voc/vocIndex");
        return mView;
    }
    //voc 만족도
    @RequestMapping(value = "/voc/satisfied", method = RequestMethod.GET)
    public ModelAndView vocstisfied(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/vocSatisfied");
        return mView;
    }
    //voc 고객 검색 팝업
    @RequestMapping(value = "/voc/pop/custsearch", method = RequestMethod.GET)
    public ModelAndView vocCustSearchPop(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();

        mView.addAllObjects(codeService.getCommonCode(USINGMENU));
        mView.addAllObjects(codeService.getCustomCode(USINGMENU, request));
        mView.setViewName("page/voc/pop/custSearchPop");
        return mView;
    }
    //voc 고객 검색 팝업 바인딩 데이터
    @RequestMapping(value = "/voc/pop/custsearch", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> vocCustSearch(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List<Map<String, Object>> custSearchList = vocService.vocSearchCustList(request);
        return custSearchList;
    }

    //고객 팝업 클릭 된 고객의 상세정보
    @RequestMapping(value = "/voc/cust/{custno}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> vocCustDetail(HttpServletRequest request, @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> custDetail = custService.custDetail(request, custno);
        return custDetail;
    }

    //voc 고객 상세
    @RequestMapping(value = "/voc/custdetail/{custNo}", method = RequestMethod.GET)
    public ModelAndView vocCustDetailPop(HttpServletRequest request, @PathVariable String custNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addObject("custDetail", custService.custDetail(request, custNo));
        mView.setViewName("page/voc/pop/custDetailPop");
        return mView;
    }

    //voc 고객 수정 실행
    @RequestMapping(value = "/voc/cust/modified/{custno}", method = RequestMethod.POST)
    @ResponseBody
    public int vocCustUpdate(HttpServletRequest request, @ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto
            , @PathVariable String custno) throws UnsupportedEncodingException, GeneralSecurityException {
        int res = vocService.vocCustUpdate(request, custDto, custDenyDto);
        return res;
    }

    //고객 추가 실행
    @RequestMapping(value = "/voc/cust/input", method = RequestMethod.POST)
    @ResponseBody
    public String vocCustInsert(HttpServletRequest request, @ModelAttribute CustDto custDto, @ModelAttribute CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        String custNo = custService.custinsert(request, custDto, custDenyDto);
        return "{\"CUSTNO\":\"" + custNo + "\"}";
    }
    //voc sms 발송 (폼)
    @RequestMapping(value = "/voc/pop/sms", method = RequestMethod.GET)
    public ModelAndView vocSmsPop(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        int sendType = 2; // sms 서식 값
        int useMenu = 5; // voc 메뉴 값
        List<Map<String, Object>> formList = vocService.getVocSendForm(request, sendType, useMenu);
        mView.addObject("formList", formList);
        mView.setViewName("page/voc/pop/vocSmsPop");
        return mView;
    }
    //voc sms 발송 (실행)
    @RequestMapping(value = "/voc/pop/sms/input", method = RequestMethod.POST)
    @ResponseBody
    public int authSmsPopSend(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        sendService.sendSmsTemp(request);
        return 0;
    }
    //voc 카카오 발송 (폼)
    @RequestMapping(value = "/voc/pop/kakao", method = RequestMethod.GET)
    public ModelAndView vocKakaoPop(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        int sendType = 3; // sms 서식 값
        int useMenu = 5; // voc 메뉴 값
        List<Map<String, Object>> formList = vocService.getVocSendForm(request, sendType, useMenu);
        mView.addObject("formList", formList);
        mView.setViewName("page/voc/pop/vocKakaoPop");
        return mView;
    }
    //voc sms 발송 (실행)
    @RequestMapping(value = "/voc/pop/kakao/input", method = RequestMethod.POST)
    @ResponseBody
    public int vocKakaoPopInsert(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        sendService.sendKakaoTemp(request);
        return 0;
    }

    //voc 메일 발송 (폼)
    @RequestMapping(value = "/voc/pop/email", method = RequestMethod.GET)
    public ModelAndView vocEmailPop(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.setViewName("page/voc/pop/vocEmailPop");
        return mView;
    }

    //VOC -  블랙 추가 폼
    @RequestMapping(value = "/voc/black", method = RequestMethod.GET)
    public String vocBlackCustForm(HttpServletRequest request) {
        return "page/voc/pop/blackCustPop";
    }

    //VOC -  블랙 추가 실행
    @RequestMapping(value = "/voc/black", method = RequestMethod.POST)
    @ResponseBody
    public int vocBlackCustInsert(HttpServletRequest request, @ModelAttribute BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException {
        return vocService.vocBlackCustInsert(request, blackCustDto);
    }

    //VOC - 블랙 해제 실행
    @RequestMapping(value = "/voc/black/del", method = RequestMethod.POST)
    @ResponseBody
    public int vocBlackCustDelete(HttpServletRequest request, @ModelAttribute BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException {
        return vocService.vocBlackCustDelete(request, blackCustDto);
    }

    //VOC -  좌측탭 서비스 리스트
    @RequestMapping(value = "/voc/tab/sv", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> vocTabServiceList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        return serviceService.serviceList(request);
    }

    //VOC -  좌측탭 블랙이력 리스트
    @RequestMapping(value = "/voc/tab/black", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> vocTabBlackHistoryList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        return vocService.blackHistoryList(request);
    }

    //VOC -  좌측탭 고객 콜백 이력 리스트
    @RequestMapping(value = "/voc/tab/callbackhist", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> vocTabCallbackHistoryList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        List callbackHisList = vocService.callBackHistoryList(request);
        return callbackHisList;
    }

    //voc 녹취듣기
    @RequestMapping(value = "/voc/pop/rec", method = RequestMethod.GET)
    public String playRecording(HttpServletRequest request) {
        return "page/voc/pop/vocRecPop";
    }

    //VOC 콜백 분배 팝업 목록 조회
    @RequestMapping(value = "/voc/tab/callback", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> vocCallBackList(HttpServletRequest request) {
        List<Map<String, Object>> callBackList = vocService.vocCallBackList(request);
        return callBackList;
    }


    //VOC 콜백 상태 변경 (상담원 제어)
    @RequestMapping(value = "/voc/callback/modified/{callbackno}", method = RequestMethod.POST)
    @ResponseBody
    public int vocCallBackUpdate(HttpServletRequest request, @PathVariable int callbackno) throws UnsupportedEncodingException, GeneralSecurityException {
        int res = vocService.vocCallBackUpdate(request);
        return res;
    }

    //VOC 녹취정보 저장
    @RequestMapping(value = "/voc/rec", method = RequestMethod.POST)
    public void VocRecInsert(HttpServletRequest request) {
        System.out.println("rec controller");
        vocService.vocRecInsert(request);
    }

    //cti 서버에서 보내주는 콜백내역 저장
    //url 변경시 온피아 전화 필요
    @RequestMapping(value = "/vc/callback", method = RequestMethod.POST)
    public void vocGetCallBack(HttpServletRequest request) {
        vocService.vocCallBackInsert(request);
        return;
    }

    //voc 고객팝업창 tr 클릭 시 해당 고객의 최근 한건의 서비스 데이터 바인딩
    @RequestMapping(value = "/voc/pop/service/info/{custNo}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> vocPopServiceSelect(HttpServletRequest request, @PathVariable String custNo) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> serviceMap = vocService.vocPopServiceSelect(request, custNo);
        return serviceMap;
    }

    //VOC - 세션유지를 위해 설정 시간마다 이 메서드가 호출된다
    @RequestMapping(value = "/voc/sess", method = RequestMethod.GET)
    @ResponseBody
    public int vocSessionMaintain(HttpServletRequest request) {
        return 0;
    }

    //voc 전화끊으면 DB에 일평균 데이터 저장
    @RequestMapping(value = "/voc/endcall", method = RequestMethod.POST)
    @ResponseBody
    public int EndCall(HttpServletRequest request) {
        vocService.vocEndCall(request);
        return 0;
    }

    // voc 서비스 추가
    @RequestMapping(value = "/voc/service/input", method = RequestMethod.POST)
    @ResponseBody
    public String vocServiceInsertSet(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ServiceDto serviceDto
            , @ModelAttribute RewardDto rewardDto, @ModelAttribute RactDto ractDto
            , @ModelAttribute ServiceDeliveryDto serviceDeliveryDto) throws UnsupportedEncodingException, GeneralSecurityException {
        String serviceNo = vocService.vocInsert(request, response, serviceDto, rewardDto, ractDto, serviceDeliveryDto);
        return "{\"SERVICENO\":\"" + serviceNo + "\"}";
    }

    //voc as 캘린더
    @RequestMapping(value = "/voc/as/cal", method = RequestMethod.GET)
    public ModelAndView authvocCalList(HttpServletRequest request) {
        ModelAndView mView = new ModelAndView();
        mView.addAllObjects(vocService.vocCalList(request));
        mView.setViewName("page/voc/calendar/vocCalMain");
        return mView;
    }

    //voc as 캘린더용 바인딩 데이터
    @RequestMapping(value = "/voc/as/cal/{asOwner}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> authVocOwnerCalList(HttpServletRequest request, @PathVariable int asOwner) {
        Map<String, Object> ownerCalList = vocService.vocOwnerList(request, asOwner);
        return ownerCalList;
    }
    //voc 상품
    @RequestMapping(value = "/voc/productB", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> authVocProudctB(HttpServletRequest request) {
        List<ProductDto> productB = productService.getProductB(request);
        return productB;
    }

    //콜백분배 팝업
    @RequestMapping(value = "/voc/pop/calldiv", method = RequestMethod.GET)
    public String authVocCallBackDiv(HttpServletRequest request) {
        return "page/voc/pop/callbackDiv";
    }

    //분배할 콜백리스트
    @RequestMapping(value = "/voc/pop/calldiv/call", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> authVocCallBackList(HttpServletRequest request) {
        Map<String, Object> callBackList = vocService.vocPopCallBackList(request);
        return callBackList;
    }

    //콜백 분배받을 유저 리스트
    @RequestMapping(value = "/voc/pop/calldiv/user", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> authVocCallBackUserList(HttpServletRequest request) {
        Map<String, Object> callBackUserList = vocService.vocCallBackUserList(request);
        return callBackUserList;
    }

    //콜백수동분배
    @RequestMapping(value = "/voc/pop/calldiv/pass", method = RequestMethod.GET)
    @ResponseBody
    public int authVocCallPassDiv(HttpServletRequest request) {
        int cnt = vocService.vocCallBackPassDiv(request);
        return cnt;
    }

    //콜백자동분배
    @RequestMapping(value = "/voc/pop/calldiv/auto", method = RequestMethod.GET)
    @ResponseBody
    public int authVocCallAtouDiv(HttpServletRequest request) {
        vocService.vocCallBackAutoDiv(request);
        return 0;
    }

    //  서비스 상세 화면
    @RequestMapping(value = "/voc/pop/service/{serviceNo}", method = RequestMethod.GET)
    public ModelAndView authServiceDetail(HttpServletRequest request, @PathVariable String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        mView.addObject("fileInfo", uploadDao.fileInfo(serviceService.serviceDetail(request, serviceNo)));
        mView.addObject("serviceInfo", serviceService.serviceDetail(request, serviceNo));
        mView.addObject("rewardInfo", serviceService.rewardDetail(request, serviceNo));
        mView.addObject("ractInfo", serviceService.ractDetail(request, serviceNo));
        mView.addObject("product", serviceService.productDetail(request, serviceNo));

        mView.setViewName("page/voc/pop/serviceDetailPop");
        return mView;
    }

    // voc 상담템플릿 선택
    @RequestMapping(value = "/voc/format/{formatNo}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> authVocFormatDetail(HttpServletRequest request, @PathVariable String formatNo) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> formatInfo = formatService.formatDetail(request, formatNo);
        return formatInfo;
    }
}

