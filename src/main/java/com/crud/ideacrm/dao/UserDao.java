package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<Map<String,Object>> userList(Map<String,Object> param);
    public Map<String, Object> userAram(int userNo);

    public String userInsert(UserDto userDto);

    public Map<String,Object> userDetail(String userNo);
}
