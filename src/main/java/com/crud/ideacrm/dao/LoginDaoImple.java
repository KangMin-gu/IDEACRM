package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class LoginDaoImple implements LoginDao{

    @Autowired
    private SqlSession session;

    @Override
    public Map<String, Object> getData(String userId) {
        Map<String, Object> urInfo= session.selectOne("login.idCheck", userId);
        return urInfo;
    }

}
