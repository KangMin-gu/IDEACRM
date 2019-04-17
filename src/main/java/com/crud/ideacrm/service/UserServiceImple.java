package com.crud.ideacrm.service;


import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.UserDao;
import com.crud.ideacrm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CodecUtil codecUtil;

    @Override
    public List<Map<String, Object>> userList(HttpServletRequest request) {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> userList = userDao.userList(param);


        return userList;
    }

    @Override
    public String userInsert(HttpServletRequest request, UserDto userDto) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        userDto.setSiteid(siteId);
        userDto.setReguser(userNo);
        userDto.setEdtuser(userNo);

        userDto.setEncodingUserDto();
        String insertUserNo = userDao.userInsert(userDto);

        insertUserNo = codecUtil.encodePkNo(insertUserNo);

        return insertUserNo;
    }

    @Override
    public Map<String,Object> userDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException {

        userNo = codecUtil.decodePkNo(userNo);

        Map<String,Object> userInfo = userDao.userDetail(userNo);
        userInfo = codecUtil.decodeMap(userInfo);

        return userInfo;
    }
}
