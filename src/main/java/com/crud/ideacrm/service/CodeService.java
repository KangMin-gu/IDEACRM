package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CodeDto;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface CodeService {
    public Map<String,Object> getCommonCode(int usingMenu);
    public Map<String,Object> getCustomCode(int usingMenu,HttpServletRequest request);
    public Map<String,Object> getCode(CodeDto codeDto);

    public List<Map<String,Object>> codeList(HttpServletRequest request,String siteId) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> codeDetail(HttpServletRequest request, String codeNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public String codeUpdate(HttpServletRequest request, CodeDto codeDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public String codeInsert(HttpServletRequest request, CodeDto codeDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public void codeDelete(HttpServletRequest request, String codeNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<CodeDto> getUpperCodeGrp(HttpServletRequest request);
}
