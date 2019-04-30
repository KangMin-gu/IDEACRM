package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface VocService {
    public int vocCustUpdate(HttpServletRequest request, CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public int vocBlackCustInsert(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public int vocBlackCustDelete(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String, Object>> blackHistoryList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String, Object>> callBackHistoryList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String, Object>> vocCallBackList(HttpServletRequest request);
    public int vocCallBackUpdate(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public void vocRecInsert(HttpServletRequest request);
    public void vocCallBackInsert(HttpServletRequest request);
    public Map<String, Object> vocPopServiceSelect(HttpServletRequest request, String custNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public void vocEndCall(HttpServletRequest request);
    public Map<String, Object> vocOwnerList(HttpServletRequest request,int asOwner);
    public List<Map<String,Object>> vocCalOwnerList (HttpServletRequest request,int asOwner);
    public Map<String,Object> vocCalList(HttpServletRequest request);
    public Map<String,Object> vocPopCallBackList(HttpServletRequest request);
    public Map<String,Object> vocCallBackUserList(HttpServletRequest request);
    public int vocCallBackPassDiv(HttpServletRequest request);
    public void vocCallBackAutoDiv(HttpServletRequest request);
    public String vocInsert(HttpServletRequest request, HttpServletResponse response, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto, ServiceDeliveryDto serviceDeliveryDto) throws UnsupportedEncodingException, GeneralSecurityException;
}
