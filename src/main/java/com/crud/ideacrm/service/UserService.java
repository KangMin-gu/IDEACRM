package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<Map<String,Object>> userList(HttpServletRequest request);

    public String userInsert(HttpServletRequest request, UserDto userDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public Map<String,Object> userDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException;
}
