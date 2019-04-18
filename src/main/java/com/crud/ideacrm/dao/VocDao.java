package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.*;

import java.util.List;
import java.util.Map;

public interface VocDao {
    public int vocCustUpdate(CustDto custDto);
    public int vocCustDenyUpdate(CustDenyDto custDenyDto);
    public int vocBlackCustInsert(BlackCustDto blackCustDto);
    public int vocBlackCustDelete(BlackCustDto blackCustDto);
    public List<Map<String, Object>> blackHistoryList(Map<String, Object> prmMap);
    public List<Map<String, Object>> callBackHistoryList(Map<String,Object> prmMap);
    public List<Map<String, Object>> vocCallBackList(Map<String, Object> prmMap);
    public int vocCallBackUpdate(Map<String, Object> prmMap);
    public int vocCallBackHistoryInsert(Map<String, Object> prmMap);
    public void vocRecInsert(Map<String, Object> prmMap);
    public void vocCallBackInsert(Map<String,Object> param);
    public Map<String,Object> svTopDesc(Map<String,Object> param);// voc 최근 서비스 한건
    public Map<String,Object> svTopResv(Map<String,Object> param);// voc 최근 상담예약 한건
    public Map<String,Object> svTopConvey(Map<String,Object> param);// voc 최근 이관 한건
    public Map<String,Object> svTopReward(Map<String,Object> param);// voc 최근 현상파악 한건
    public List<ProductDto> svProductRead(Map<String,Object> param);
    public String svInsert(ServiceDto serviceDto);
    public void svStepUpdate(ServiceDto serviceDto);
    public void svReservInsert(Map<String,Object> param);// voc 상담예약
    public void conveyInsert(ServiceDeliveryDto serviceDeliveryDto); // 이관 추가

}
