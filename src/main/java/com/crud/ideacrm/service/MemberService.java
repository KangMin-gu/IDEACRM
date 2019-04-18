package com.crud.ideacrm.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface MemberService {
    public ModelAndView userInfo(HttpServletRequest request, int userId);
    public void userPwdReset(HttpServletRequest request);
}