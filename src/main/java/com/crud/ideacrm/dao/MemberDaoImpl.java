package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SqlSession Session;


    @Override
    public Map<String, Object> userInfo(int userId) {
        Map<String, Object> userInfo = Session.selectOne("user.userInfo",userId);
        return userInfo;
    }

    @Override
    public void memeberChangePwd(UserDto userDto) {
        Session.update("user.pwdChange", userDto);
    }
}
