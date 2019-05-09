package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustDaoImple implements CustDao {

    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> custList(Map<String, Object> searchPrm) {
        return session.selectList("cust.custList",searchPrm);
    }

    @Override
    public Map<String, Object> custDetail(CustDto custDto) {
        return session.selectOne("cust.custDetail",custDto);
    }

    @Override
    public int custInsert(CustDto custDto) {
        return session.insert("cust.custInsert",custDto);
    }

    @Override
    public int custDenyInsert(CustDenyDto custDenyDto) {
        return session.insert("cust.custDenyInsert",custDenyDto);
    }

    @Override
    public int mergeCliCust(CustDto custDto) {
        return session.insert("cust.mergeCliCust",custDto);
    }

    //고객 수정
    @Override
    public int custUpdate(CustDto custDto) {
        int res = session.update("cust.custUpdate", custDto);
        return res;
    }
    //고객 수정 - 수신거부테이블
    @Override
    public int custDenyUpdate(CustDenyDto custDenyDto) {
        int res = session.update("cust.custDenyUpdate", custDenyDto);
        return res;
    }

    //고객 삭제
    @Override
    public int custDelete(CustDto custDto) {
        int res = session.update("cust.custDelete",custDto);
        return res;
    }
    //고객 수신거부 삭제
    @Override
    public int custDenyDelete(CustDto custDto) {
        int res = session.update("cust.custDenyDelete",custDto);
        return res;
    }

    @Override
    public List<Map<String, Object>> custMailList(Map<String, Object> searchPrm) {
        List<Map<String,Object>> mailList = session.selectList("cust.custMailList",searchPrm);
        return mailList;
    }

    @Override
    public List<Map<String, Object>> custSmsList(Map<String, Object> searchPrm) {
        List<Map<String,Object>> smsList = session.selectList("cust.custSmsList",searchPrm);
        return smsList;
    }

    @Override
    public List<Map<String, Object>> custMmsList(Map<String, Object> searchPrm) {
        List<Map<String, Object>> mmsList = session.selectList("cust.custMmsList", searchPrm);
        return mmsList;
    }

    @Override
    public List<Map<String, Object>> custLmsList(Map<String, Object> searchPrm) {
        List<Map<String, Object>> lmsList = session.selectList("cust.custLmsList",searchPrm);
        return lmsList;
    }

    @Override
    public List<Map<String, Object>> custKakaoList(Map<String, Object> searchPrm) {
        List<Map<String, Object>> kakaoList = session.selectList("cust.custKakaoList",searchPrm);
        return kakaoList;
    }





}
