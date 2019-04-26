package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UserCtiDto;
import com.crud.ideacrm.dto.UserDto;
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

    @Override
    public String userInsert(UserDto userDto) {
        session.insert("user.userInsert",userDto);
        String userNo = userDto.getUserno();
        return userNo;
    }

    @Override
    public void userCtiInsert(UserCtiDto userCtiDto) {
        session.insert("user.userCtiInsert",userCtiDto);
    }

    @Override
    public Map<String, Object> userDetail(UserDto userDto) {
        Map<String,Object> userDetail = session.selectOne("user.userDetail",userDto);
        return userDetail;
    }

    @Override
    public Map<String, Object> userCtiDetail(UserCtiDto userCtiDto) {
        Map<String,Object> userCtiDetail = session.selectOne("user.userCtiDetail",userCtiDto);
        return userCtiDetail;
    }

    @Override
    public void userUpdate(UserDto userDto) {
        session.update("user.userUpdate",userDto);
    }

    @Override
    public void userCtiUpdate(UserCtiDto userCtiDto) {
        session.update("user.userCtiUpdate",userCtiDto);
    }

    @Override
    public List<Map<String,Object>> userAsOwner(int siteId){
        List<Map<String,Object>> asOwner = session.selectList("user.userAsOwner",siteId);
        return asOwner;
    }


}
