package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface CustService {

    public List<Map<String,Object>> custList(Map<String,Object> searchPrm) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> custDetail(CustDto custDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public String custinsert(CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public String custUpdate(CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public int custDelete(CustDto custDto, String[] custnoArr) throws UnsupportedEncodingException, GeneralSecurityException;
}
