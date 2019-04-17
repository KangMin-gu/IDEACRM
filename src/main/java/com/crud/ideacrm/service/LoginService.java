package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.UserDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public interface LoginService {
    public ModelAndView login(HttpServletResponse response, HttpServletRequest request, UserDto urDto) throws UnsupportedEncodingException, GeneralSecurityException;
}
