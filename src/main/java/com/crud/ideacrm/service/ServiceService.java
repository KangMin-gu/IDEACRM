package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface ServiceService {

    public List<Map<String,Object>> serviceList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;

    public Map<String,Object> serviceDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> rewardDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public Map<String,Object> ractDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<ProductDto> productDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public String serviceInsertUpdate(HttpServletRequest request, HttpServletResponse response, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public void serviceDelete(HttpServletRequest request,String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;

    public List<Map<String,Object>> ractList(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;
    public List<Map<String,Object>> conveyList(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException;

    public String serviceDeliveryInsert(HttpServletRequest request, ServiceDeliveryDto serviceDeliveryDto) throws UnsupportedEncodingException, GeneralSecurityException;

    public ModelAndView serviceCalList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException;


}
