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
    SqlSession session;

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
}
