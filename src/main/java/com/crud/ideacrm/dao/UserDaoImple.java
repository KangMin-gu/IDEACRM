package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class UserDaoImple implements UserDao {

    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> userList(Map<String, Object> param) {
        List<Map<String,Object>> userList = session.selectList("user.userList",param);
        return userList;
    }

    @Override
    public Map<String, Object> userAram(int userNo) {
        Map<String, Object> userAram = session.selectOne("user.userAram", userNo);
        return userAram;
    }
}
