package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
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

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String deRelCustNo = codecUtil.decodePkNo(enCustDto.getRelcustno());
        enCustDto.setRelcustno(deRelCustNo);
        enCustDto.setCustno(deCustNo);

        int res = vocDao.vocCustUpdate(enCustDto);//업데이트 dao호출
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
                serviceMap.put("reward", vocDao.svTopReward(searchPrm));
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
    public List<Map<String,Object>> vocPopCallBackList(HttpServletRequest request){
        Map<String,Object> param = parameterUtil.searchParam(request);
        List<Map<String,Object>> callBackList = vocDao.vocPopCallBackList(param);
        return callBackList;
    }

    @Override
    public List<Map<String,Object>> vocCallBackUserList(HttpServletRequest request){
        Map<String,Object> param = parameterUtil.searchParam(request);
        List<Map<String,Object>> callBackUserList = userDao.userList(param);
        return callBackUserList;
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
    public int vocCallBackAutoDiv(HttpServletRequest request) {
        Map<String,Object> param = parameterUtil.searchParam(request);

        int userCnt = vocDao.vocCallUserCnt(param);

        int callBackCnt = vocDao.vocCallBackTotalRow(param);

        int totalCnt = (callBackCnt/userCnt);
        if(totalCnt == 0) {
            totalCnt ++;
        }
        param.put("totalCnt", totalCnt);

        int cnt = 0;

        List<Map<String,Object>> userList = userDao.userList(param);

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
    }

}
