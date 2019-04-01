package com.crud.ideacrm.dao;

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
}
