package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.UserCtiDto;
import com.crud.ideacrm.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<Map<String,Object>> userList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String,Object>> userTabList(String siteId) throws UnsupportedEncodingException, GeneralSecurityException;

    public String userInsert(HttpServletRequest request, UserDto userDto, UserCtiDto userCtiDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public Map<String,Object> userDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException;

    public Map<String,Object> userCtiDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException;

    public void userUpdate(HttpServletRequest request, String userNo, UserDto userDto,UserCtiDto userCtiDto) throws UnsupportedEncodingException, GeneralSecurityException;
}
