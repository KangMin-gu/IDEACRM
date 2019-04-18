package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.ServiceDao;
import com.crud.ideacrm.dao.VocDao;
import com.crud.ideacrm.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VocServiceImple implements VocService {

    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private VocDao vocDao;
    @Autowired
    private ParameterUtil parameterUtil;
    @Autowired
    private ServiceDao svDao;

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
    public Map<String, Object> svcVocPopServiceSelect(HttpServletRequest request,String custNo) throws UnsupportedEncodingException, GeneralSecurityException {

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



}
