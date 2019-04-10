package com.crud.ideacrm.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<Map<String,Object>> userList(Map<String,Object> param);
    public Map<String, Object> userAram(int userNo);
}
