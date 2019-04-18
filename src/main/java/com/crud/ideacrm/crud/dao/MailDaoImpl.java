package com.crud.ideacrm.crud.dao;

import java.util.List;
import java.util.Map;

import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

@Repository
public class MailDaoImpl implements MailDao {

    @Autowired
    private SqlSession session;


    @Override
    public List<Map<String, Object>> allTarget(MailDto emailDto) {
        List<Map<String, Object>> list = session.selectList("email.allTarget", emailDto);
        return list;
    }

    @Override
    public void UpdateMailState(MailDto emailDto) { session.update("email.sendstate", emailDto); }

    @Override
    public void mailClick(MailDto emailDto) {
        session.update("email.clickCnt",emailDto);
    }

    @Override
    public void mailDeny(MailDto emailDto) {
        session.update("email.denyEmail",emailDto);
    }

    @Override
    public void clickHistory(Map<String, Object> param) {
        session.insert("email.clickHistory",param);
    }

    //유저 메일 수정 프로시저
    @Override
    public void PwdChangeMailProcedure(Map<String, Object> userVal) {
        session.insert("email.pwdChangeMail", userVal);
    }
}
