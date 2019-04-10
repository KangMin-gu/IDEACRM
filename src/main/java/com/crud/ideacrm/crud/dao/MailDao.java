package com.crud.ideacrm.crud.dao;

import com.crud.ideacrm.crud.dto.MailDto;

import java.util.List;
import java.util.Map;

public interface MailDao {
    public List<Map<String, Object>> allTarget(MailDto emailDto);
    public void UpdateMailState(MailDto emailDto);
    public void mailClick(MailDto emailDto);
    public void mailDeny(MailDto emailDto);
    public void clickHistory(Map<String,Object> param);
}
