package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClientDaoImple implements ClientDao {
    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> clientList(Map<String, Object> searchParam) {
        return session.selectList("client.clientList",searchParam);
    }
}
