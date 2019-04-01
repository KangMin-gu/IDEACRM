package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ServiceDaoImple implements ServiceDao {

    @Autowired
    private SqlSession session;
    @Override
    public List<Map<String, Object>> serviceList(Map<String, Object> param) {

        List<Map<String,Object>> serviceList = session.selectList("service.list",param);
        return serviceList;

    }
}
