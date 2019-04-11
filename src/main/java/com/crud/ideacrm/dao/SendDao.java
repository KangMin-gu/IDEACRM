package com.crud.ideacrm.dao;

import java.util.Map;

public interface SendDao {

    public void directSendSms(Map<String,Object> param);
    public void directSendLms(Map<String,Object> param);
}
