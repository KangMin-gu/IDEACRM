package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.FormatDto;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface FormatService {

    public List<Map<String,Object>> formatList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public String formatInsert(HttpServletRequest request, FormatDto formatDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> formatDetail(HttpServletRequest request, String formatNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public void formatUpdate(HttpServletRequest request,FormatDto formatDto,String formatNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public void formatDelete(HttpServletRequest request,String formatNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String,Object>> smsFormat(HttpServletRequest request);
    public List<Map<String,Object>> emailFormat(HttpServletRequest request);
    public Map<String, Object> formatDesc(int formatnum);
}
