package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.BlackCustDto;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

import javax.servlet.http.HttpServletRequest;
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
    public Map<String, Object> svcVocPopServiceSelect(HttpServletRequest request, String custNo) throws UnsupportedEncodingException, GeneralSecurityException;

}
