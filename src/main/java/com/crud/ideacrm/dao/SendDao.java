package com.crud.ideacrm.dao;

import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.dto.ChargeDto;

import java.util.Map;

public interface SendDao {

    public void directSendSms(Map<String,Object> param);
    public void directSendLms(Map<String,Object> param);
    public int totalSms(Map<String,Object> param);
    public int totalMms(Map<String,Object> param);
    public int totalLms(Map<String,Object> param);
    public int totalKakao(Map<String,Object> param);
    public int totalEmail(Map<String,Object> param);
    public ChargeDto chareType(String siteId);
}
