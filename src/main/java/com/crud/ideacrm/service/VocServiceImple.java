package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.PagingUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.crud.util.Uplaod;
import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dao.ServiceDao;
import com.crud.ideacrm.dao.UserDao;
import com.crud.ideacrm.dao.VocDao;
import com.crud.ideacrm.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VocServiceImple implements VocService {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private VocDao vocDao;
    @Autowired
    private ParameterUtil parameterUtil;
    @Autowired
    private ServiceDao svDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Uplaod uplaod;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private PagingUtil pageUtil;
    @Autowired
    private CustDao custDao;

    //고객 수정 실행
    @Override
    public int vocCustUpdate(HttpServletRequest request, CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);

        CustDto enCustDto = new EnCustDto(custDto);
        String enCustNo = enCustDto.getCustno();
        String deCustNo = codecUtil.decodePkNo(enCustNo);
        String deRelCustNo = enCustDto.getRelcustno();
        enCustDto.setCustno(deCustNo);

        if(deRelCustNo != null && deRelCustNo != "0" && !deRelCustNo.equals("")){
            deRelCustNo = codecUtil.decodePkNo(deRelCustNo);
            enCustDto.setRelcustno(deRelCustNo);
        }
        if(deRelCustNo.equals("")){enCustDto.setRelcustno("0"); }

        int res = vocDao.vocCustUpdate(enCustDto);//업데이트  dao호출
        //업데이트한 pk값 수신거부 dto에 설정
        String custno = enCustDto.getCustno();
        custDenyDto.setCustno(custno);
        //수신거부 dao 호출
        vocDao.vocCustDenyUpdate(custDenyDto);
        return res;
    }

    //강성고객 등록
    @Override
    public int vocBlackCustInsert(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        blackCustDto.setReguser(userno);
        blackCustDto.setSiteid(siteid);
        String enCustNo = blackCustDto.getCustno();
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            blackCustDto.setCustno(deCustNo);
        }
        return vocDao.vocBlackCustInsert(blackCustDto);
    }

    //강성고객 취소
    @Override
    public int vocBlackCustDelete(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        blackCustDto.setEdtuser(userno);
        blackCustDto.setSiteid(siteid);
        String enCustNo = blackCustDto.getCustno();
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            blackCustDto.setCustno(deCustNo);
        }
        return vocDao.vocBlackCustDelete(blackCustDto);
    }

    //고객 블랙 등록 이력 출력
    @Override
    public List<Map<String, Object>> blackHistoryList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> searchVal = parameterUtil.searchParam(request);
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        searchVal.put("siteid", siteid);

        String enCustNo = (String)searchVal.get("custno");
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            searchVal.put("custno",deCustNo);
        }

        return vocDao.blackHistoryList(searchVal);
    }

    //해당 고객의 콜백이력 출력
    @Override
    public List<Map<String, Object>> callBackHistoryList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String, Object> searchVal = parameterUtil.searchParam(request);
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        searchVal.put("siteid", siteid);

        String enCustNo = (String)searchVal.get("custno");
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            searchVal.put("custno",deCustNo);
        }
        return vocDao.callBackHistoryList(searchVal);
    }

    //voc 콜백 리스트
    @Override
    public List<Map<String, Object>> vocCallBackList(HttpServletRequest request) {
        Map<String, Object> searchVal = parameterUtil.searchParam(request);
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        searchVal.put("userno", userno);
        return vocDao.vocCallBackList(searchVal);
    }

    @Override
    public int vocCallBackUpdate(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> callBackPrm = parameterUtil.searchParam(request);
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        callBackPrm.put("userno", userno);

        String enCustNo = (String)callBackPrm.get("custno");
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            callBackPrm.put("custno",deCustNo);
        }

        int res = vocDao.vocCallBackUpdate(callBackPrm);
        vocDao.vocCallBackHistoryInsert(callBackPrm);
        return res;
    }

    //녹취 저장
    @Override
    public void vocRecInsert(HttpServletRequest request) {
        Map<String,Object> param = parameterUtil.searchParam(request);
        vocDao.vocRecInsert(param);
    }

    //voc 콜백 추가. cti에서 보내 준 데이터 콜백 테이블에 insert
    @Override
    public void vocCallBackInsert(HttpServletRequest request) {
        Map<String,Object> callBackMap = parameterUtil.searchParam(request);
        callBackMap.put("callstatus", 0);
        callBackMap.put("callcount", 0);
        vocDao.vocCallBackInsert(callBackMap);
    }

    @Override
    public Map<String, Object> vocPopServiceSelect(HttpServletRequest request,String custNo) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String,Object> searchPrm = parameterUtil.searchParam(request);
        searchPrm.put("custno", custNo);//복호화필요
        if(custNo != null && !custNo.equals("0") && !custNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(custNo);
            searchPrm.put("custno",deCustNo);
        }


        Map<String,Object> serviceMap = vocDao.svTopDesc(searchPrm);
        if(serviceMap != null) {
            int serviceStep = Integer.parseInt(serviceMap.get("SERVICESTEP").toString());
            int serviceNo = Integer.parseInt(serviceMap.get("SERVICENO").toString());
            int serviceType = Integer.parseInt(serviceMap.get("SERVICETYPE").toString());
            searchPrm.put("serviceno",serviceNo);
            if(serviceType == 1) {
                if(serviceStep == 4) {
                    serviceMap.put("reserv", vocDao.svTopResv(searchPrm));
                }else if(serviceStep == 5 || serviceStep == 6) {
                    serviceMap.put("convey", vocDao.svTopConvey(searchPrm));
                }
            }else if(serviceType == 2) {
                Map rewardMap = vocDao.svTopReward(searchPrm);
                rewardMap = codecUtil.decodeMap(rewardMap);
                serviceMap.put("reward", rewardMap);
            }
            serviceMap.put("product", vocDao.svProductRead(searchPrm));

        }else {
            serviceMap = new HashMap<>();
        }
        return serviceMap;
    }

    // VOC 전화 종료하면 일평균 데이터 수집
    @Override
    public void vocEndCall(HttpServletRequest request) {
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        Map<String,Object> param = parameterUtil.searchParam(request);
        param.put("userno",userNo);
        vocDao.endCall(param);
    }

    @Override
    public Map<String, Object> vocOwnerList(HttpServletRequest request,int asOwner) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        Map<String,Object> ownerCalList = new HashMap();
        RewardDto rewardDto = new RewardDto();
        rewardDto.setSiteid(siteId);
        rewardDto.setOwner(asOwner);
        List<Map<String,Object>> rewardOwnerList = svDao.svCalRewardOwner(rewardDto);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rewardOwnerList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ownerCalList.put("schList",jsonStr);//캘린더 스케쥴
        ownerCalList.put("svSchList",rewardOwnerList);//캘린더 틀 목록.
        return ownerCalList;
    }

    @Override
    public List<Map<String,Object>> vocCalOwnerList (HttpServletRequest request,int asOwner) {
        Map<String,Object> param = parameterUtil.searchParam(request);
        param.put("owner",asOwner);
        List<Map<String,Object>> calOwner = svDao.calRewardOwnerList(param);
        return calOwner;
    }

    @Override
    public Map<String,Object> vocCalList(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        Map<String,Object> resultMap = new HashMap<String,Object>();
        RewardDto rewardDto = new RewardDto();
        Map<String,Object> search = parameterUtil.searchParam(request);
        if(request.getParameter("asowner") != null) {
            int as = Integer.parseInt(request.getParameter("asowner").toString());
            rewardDto.setOwner(as);
        }
        rewardDto.setSiteid(siteId);

        List<Map<String,Object>> rewardOwnerList = svDao.svCalRewardOwner(rewardDto);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rewardOwnerList);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

        List<Map<String,Object>> owner = userDao.userList(search);
        List<Map<String,Object>> asOwner = userDao.userAsOwner(siteId);

        resultMap.put("schList",jsonStr);//캘린더 스케쥴
        resultMap.put("svSchList",rewardOwnerList);//캘린더 틀 목록.
        resultMap.put("asOwner",asOwner);
        resultMap.put("search",search);
        resultMap.put("owner",owner);

        return resultMap;
    }

    @Override
    public Map<String,Object> vocPopCallBackList(HttpServletRequest request){
        Map<String,Object> param = parameterUtil.searchParam(request);
        int PAGE_ROW_COUNT = 10;
        int PAGE_DISPLAY_COUNT = 5;

        int totalRows = vocDao.vocCallBackTotalRow(param);

        Map<String, Integer> page = pageUtil.paging(request, totalRows, PAGE_ROW_COUNT, PAGE_DISPLAY_COUNT);
        int startRowNum = page.get("startRowNum");
        int endRowNum = page.get("endRowNum");

        param.put("startRowNum", startRowNum);
        param.put("endRowNum", endRowNum);
        List<Map<String,Object>> callBackList = vocDao.vocPopCallBackList(param);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("callBack", callBackList);
        resultMap.put("page", page);
        resultMap.put("totalRows",totalRows);
        return resultMap;
    }

    @Override
    public Map<String,Object> vocCallBackUserList(HttpServletRequest request){
        Map<String,Object> param = parameterUtil.searchParam(request);
        int PAGE_ROW_COUNT = 10;
        int PAGE_DISPLAY_COUNT = 5;

        int totalRows = vocDao.vocUserTotalRows(param);

        Map<String, Integer> page = pageUtil.paging(request, totalRows, PAGE_ROW_COUNT, PAGE_DISPLAY_COUNT);
        int startRowNum = page.get("startRowNum");
        int endRowNum = page.get("endRowNum");

        param.put("startRowNum", startRowNum);
        param.put("endRowNum", endRowNum);
        List<Map<String,Object>> callBackUserList = vocDao.vocUserList(param);

        Map<String,Object> result = new HashMap<>();
        result.put("callBackUser", callBackUserList);
        result.put("page", page);
        result.put("totalRows",totalRows);
        return result;
    }



    @Override
    public int vocCallBackPassDiv(HttpServletRequest request) {

        Map<String,Object> param = parameterUtil.searchParam(request);

        String[] callBackArray = param.get("callBackNo").toString().split(",");
        List<String> callBack = new ArrayList<String>();

        for(int i=0;i<callBackArray.length;i++) {
            callBack.add(callBackArray[i]);
        }
        param.put("callBackNo", callBack);

        int cnt = vocDao.vocCallBackPassDiv(param);

        return cnt;
    }

    @Override
    public void vocCallBackAutoDiv(HttpServletRequest request) {
        Map<String,Object> param = parameterUtil.searchParam(request);
        int callStatus = -1; // 차후 기능 확장 시 사용 (상태값에 따른 제어)
        param.put("callstatus",callStatus);
        vocDao.callbackAutoDiv(param);
/*
        int userCnt = vocDao.vocCallUserCnt(param);

        int callBackCnt = vocDao.vocCallBackTotalRow(param);

        int totalCnt = (callBackCnt/userCnt);
        if(totalCnt == 0) {
            totalCnt ++;
        }
        param.put("totalCnt", totalCnt);

        int cnt = 0;

        List<Map<String,Object>> userList = vocDao.vocUserList(param);

        int userListSize = userList.size();
        int userNo = 0;
        String userName ="";
        int callBackListSize = 0;
        int callBackNo = 0;
        List<Map<String,Object>> callBackList = new ArrayList<Map<String,Object>>();

        for(int i=0;i<userListSize;i++) {
            userNo = Integer.parseInt(userList.get(i).get("USERNO").toString());
            userName = userList.get(i).get("USERNAME").toString();
            callBackList = vocDao.vocPopCallBackList(param);
            callBackListSize = callBackList.size();

            for(int j=0;j<callBackListSize;j++) {
                callBackNo = Integer.parseInt(callBackList.get(j).get("CALLBACKNO").toString());

                param.put("userNo", userNo);
                param.put("callBackNo", callBackNo);

                vocDao.vocCallBackDiv(param);
                cnt++;
            }
        }
        if(callBackCnt > cnt) {
            vocCallBackAutoDiv(request);
        }
        return cnt;

       */
    }

    @Override
    public String vocInsert(HttpServletRequest request, HttpServletResponse response, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto, ServiceDeliveryDto serviceDeliveryDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        Map<String,Object> search = parameterUtil.searchParam(request);

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
        Date currentTime = new Date ();
        String receptiondate = mSimpleDateFormat.format ( currentTime );//현재시간

        if(serviceDto.getOwner() == 0 ){ serviceDto.setOwner(userNo); }//별도로 입력한 담당자가 없다면 기본값은 로그인 한 유저
        if(serviceDto.getServiceowner() == 0 ){ serviceDto.setServiceowner(userNo); } //별도로 입력한 서비스담당자가 없다면 기본값은 로그인 한 유저
        if(serviceDeliveryDto.getNextowner() != 0 ) { serviceDto.setOwner( serviceDeliveryDto.getNextowner() ); } // 이관담당자가 있다면 값 셋팅
        serviceDto.setSiteid(siteId);
        serviceDto.setEdtuser(userNo);
        serviceDto.setReguser(userNo);
        serviceDto.setReceptiondate(receptiondate);

        rewardDto.setSiteid(siteId);
        rewardDto.setEdtuser(userNo);
        ractDto.setSiteid(siteId);
        ractDto.setEdtuser(userNo);
        /* 첨부파일 */
        List<MultipartFile> serviceFile = serviceDto.getFiles();
        if(serviceFile  != null && serviceFile.size() > 0 && serviceFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, serviceFile);
            serviceDto.setFilesearchkey(fileSearchKey);
        }

        String custNo = codecUtil.decodePkNo(serviceDto.getCustno());
        serviceDto.setCustno(custNo);

        serviceDto.setIsdelete(0);
        String serviceNo = serviceDao.serviceInsert(serviceDto);
        String visitDate = rewardDto.getVisitdate();

        int rewardNo = rewardDto.getRewardno();

        // 방문 일정이 잡히면 현상파악을 Insert 하게됨.
        if(visitDate != null && !visitDate.equals("")) {
            rewardDto.setEncodingRewardDto();
            rewardDto.setServiceno(serviceNo);
            if(search.get("asowner") != null){
               rewardDto.setOwner( Integer.parseInt((String)search.get("asowner")) );
            }
            rewardDto.setReguser(userNo);
            serviceDao.rewardInsert(rewardDto);
            serviceDto.setServicestep(2);
            serviceDao.serviceStepUpdate(serviceDto);
        }

        String ractDate = ractDto.getRactdate();
        int ractNo = ractDto.getRactno();

        if(ractDate != null && !ractDate.equals("")) {
            if(ractNo != 0) {
                ractDto.setServiceno(serviceNo);
                serviceDao.ractUpdate(ractDto);
            }else{
                ractDto.setServiceno(serviceNo);
                ractDto.setReguser(userNo);
                ractDto.setRactdate(receptiondate);
                serviceDao.ractInsert(ractDto);
                serviceDto.setServicestep(3);
                serviceDao.serviceStepUpdate(serviceDto);
            }
        }

        int svStep = serviceDto.getServicestep();
        if(svStep == 5 || svStep == 6){
            serviceDeliveryDto.setServiceno(serviceNo);
            serviceDeliveryDto.setPrevowner(userNo);//voc에서 입력과 동시에 이관하기때문에 이전담당자는 로그인 회원
            serviceDeliveryDto.setReguser(userNo);
            serviceDeliveryDto.setEdtuser(userNo);
            serviceDeliveryDto.setSiteid(siteId);
            serviceDeliveryDto.setConveydate(receptiondate);
            vocDao.conveyInsert(serviceDeliveryDto);
        }else if(svStep == 3){
            ractDto.setRactdesc(serviceDto.getServicedesc());
            ractDto.setServiceno(serviceNo);
            ractDto.setReguser(userNo);
            ractDto.setRactdate(receptiondate);
            serviceDao.ractInsert(ractDto);
            serviceDto.setServicestep(3);
            serviceDao.serviceStepUpdate(serviceDto);
        }

        int cnt = 0;
        Map<String,Object> map = new HashMap();
        TreeMap<String,Object> treeMap = new TreeMap<String,Object>(search);

        String key;
        String value;

        Iterator<String> keyiterator = treeMap.keySet().iterator();
        map.put("siteid", siteId);
        map.put("reguser", userNo);
        map.put("edtuser", userNo);
        map.put("serviceno", serviceNo);
        while(keyiterator.hasNext()) {
            key = keyiterator.next().toString();
            if(search.get(key) != null) {
                value = search.get(key).toString();
                if(key.contains("product")) {
                    cnt ++;
                    if(cnt == 1) {
                        map.put("productb", value);
                    }else if(cnt ==2) {
                        map.put("productm", value);
                    }else if(cnt ==3) {
                        map.put("products", value);
                        cnt = 0;
                        serviceDao.serviceProductInsert(map);
                    }
                }
            }
        }
        serviceNo = codecUtil.encodePkNo(serviceNo);
        return serviceNo;
    }

    @Override
    public List<Map<String, Object>> getVocSendForm(HttpServletRequest request, int sendType, int useMenu) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> param = parameterUtil.searchParam(request);
        param.put("usemenu", useMenu);
        param.put("sendtype",sendType);
        List<Map<String,Object>> sendformList = vocDao.getVocSendForm(param);

        int len = sendformList.size();
        String formatno;
        for(int i=0;i<len;i++){
            formatno = "";
            formatno = Integer.toString((int)sendformList.get(i).get("FORMATNO"));
            formatno = codecUtil.encodePkNo(formatno);
            sendformList.get(i).put("FORMATNO",formatno);
        }
        return sendformList;
    }

    //voc 팝업 고객 리스트
    @Override
    public List<Map<String, Object>> vocSearchCustList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> param = parameterUtil.searchParam(request);
        List<Map<String,Object>> custList = custDao.custList(param);
        custList = codecUtil.decodeList(custList);//복호화

        String tmp;
        for(int i=0;i<custList.size();i++){

            //pk값 암호화
            String custNo = Integer.toString( (int)(custList.get(i).get("CUSTNO")));
            String enCustNo = codecUtil.encodePkNo(custNo);
            custList.get(i).put("CUSTNO",enCustNo);

            if( custList.get(i).get("MOBILE") != null ){
                tmp = "";
                tmp = (String)custList.get(i).get("MOBILE");
                tmp = codecUtil.removeHyphen(tmp);// '-' 제거
                if(tmp.contains("null")){ tmp = codecUtil.removeNullText(tmp);  }// null text 제거
                custList.get(i).put("MOBILE",tmp);
            }
            if( custList.get(i).get("HOMTEL") != null ){
                tmp = "";
                tmp = (String)custList.get(i).get("HOMTEL");
                tmp = codecUtil.removeHyphen(tmp);
                if(tmp.contains("null")){ tmp = codecUtil.removeNullText(tmp);  }
                custList.get(i).put("HOMTEL",tmp);
            }
            if( custList.get(i).get("WRKTEL") != null ){
                tmp = "";
                tmp = (String)custList.get(i).get("WRKTEL");
                tmp = codecUtil.removeHyphen(tmp);
                if(tmp.contains("null")){ tmp = codecUtil.removeNullText(tmp);  }
                custList.get(i).put("WRKTEL",tmp);
            }
        }
        return custList;
    }

}
