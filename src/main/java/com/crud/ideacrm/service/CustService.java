package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface CustService {

    public List<Map<String,Object>> custList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> custDetail(HttpServletRequest request, String custNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public String custinsert(HttpServletRequest request,CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public String custUpdate(HttpServletRequest request,CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public int custDelete(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String,Object>> GetCustMailList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
}
