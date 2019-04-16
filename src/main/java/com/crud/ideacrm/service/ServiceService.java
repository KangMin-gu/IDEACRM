package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.RactDto;
import com.crud.ideacrm.dto.RewardDto;
import com.crud.ideacrm.dto.ServiceDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface ServiceService {

    public List<Map<String,Object>> serviceList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;
    public ModelAndView serviceDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public String serviceInsertUpdate(HttpServletRequest request, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public void serviceDelete(HttpServletRequest request,String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;

    public List<Map<String,Object>> ractList(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String,Object>> conveyList(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;


}
