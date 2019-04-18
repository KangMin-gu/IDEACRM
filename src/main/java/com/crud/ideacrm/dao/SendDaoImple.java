package com.crud.ideacrm.dao;

import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.dto.ChargeDto;
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

    @Override
    public int totalSms(Map<String,Object> param) {
        int totalSms = session.selectOne("send.totalSms",param);
        return totalSms;
    }

    @Override
    public int totalMms(Map<String,Object> param) {
        int totalMms = session.selectOne("send.totalMms",param);
        return totalMms;
    }

    @Override
    public int totalLms(Map<String,Object> param) {
        int totalLms = session.selectOne("send.totalLms",param);
        return totalLms;
    }

    @Override
    public int totalKakao(Map<String,Object> param) {
        int totalKakao = session.selectOne("send.totalKakao",param);
        return totalKakao;
    }

    @Override
    public int totalEmail(Map<String,Object> param) {
        int totalEmail = session.selectOne("send.totalEmail",param);
        return totalEmail;
    }

    @Override
    public ChargeDto chareType(String siteId) {
        ChargeDto chargeDto = session.selectOne("send.chargeType",siteId);
        return chargeDto;
    }

}
