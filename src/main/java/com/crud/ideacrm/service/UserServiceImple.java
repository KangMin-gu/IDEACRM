package com.crud.ideacrm.service;


import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Map<String, Object>> userList(HttpServletRequest request) {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> userList = userDao.userList(param);


        return userList;
    }
}
