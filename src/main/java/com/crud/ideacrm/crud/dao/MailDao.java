package com.crud.ideacrm.crud.dao;

import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface MailDao {
    public List<Map<String, Object>> allTarget(Map<String,Object> mailVal);
    public void UpdateMailState(MailDto emailDto);
    public List<Map<String, Object>> files(String fileSearchKey);
    public void PwdChangeMailProcedure(Map<String, Object> userVal);
    public void emailSend(MailDto mailDto);

    public void mailClick(MailDto emailDto);
    public void mailDeny(MailDto emailDto);
    public void clickHistory(Map<String,Object> param);

}
