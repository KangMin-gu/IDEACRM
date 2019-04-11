package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SendDaoImple implements SendDao{

    @Autowired
    private SqlSession session;

    @Override
    public void directSendSms(Map<String, Object> param) {
        session.insert("send.directSmsSend",param);
    }

    @Override
    public void directSendLms(Map<String, Object> param) {
        session.insert("send.directLmsSend",param);
    }
}
