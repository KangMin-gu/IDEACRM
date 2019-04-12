package com.crud.ideacrm.crud.util;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface CrudCommonUtil {
    public String encoding(String arg) throws UnsupportedEncodingException, GeneralSecurityException;
    public String decoding(String arg) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String, Object> searchParam(HttpServletRequest request);
    public Map<String, Object> decodeMap(Map<String,Object> map) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String, Object>> decodeList(List<Map<String,Object>> list) throws UnsupportedEncodingException, GeneralSecurityException;
    public String[] setPhoneArr(String name,String value,String[] valArr);
    public String parsingPhoneNo(String[] phoneArr);
    public String encodePkNo(String pkNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public String decodePkNo(String pkNo) throws UnsupportedEncodingException, GeneralSecurityException;
}
