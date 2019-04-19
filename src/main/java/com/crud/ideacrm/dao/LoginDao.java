package com.crud.ideacrm.dao;

import com.crud.ideacrm.crud.dto.ContactInfoDto;

import java.util.Map;

public interface LoginDao {
    public Map<String, Object> getData(String userId);
    public void contactInfo(ContactInfoDto ciDto);
    public Map<String, Object> userInfo(int userNo);
}

