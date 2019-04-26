package com.crud.ideacrm.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Map;

public interface MemberService {
    public void userPwdReset(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

   // public int memberIdCheck(HttpServletRequest request, String userId);
   public int memberIdCheck(HttpServletRequest request);
}
