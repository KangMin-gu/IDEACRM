package com.crud.ideacrm.service;


import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.UserDao;
import com.crud.ideacrm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private PasswordEncoder encoder;
// 사용자 List
    @Override
    public List<Map<String, Object>> userList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> userList = userDao.userList(param);
        for(int i=0;i<userList.size();i++){ //pk값 암호화
            String deUserNo = "";
            deUserNo = userList.get(i).get("NO").toString();
            String enUserNo = codecUtil.encodePkNo(deUserNo);
            userList.get(i).put("NO",enUserNo);
        }
        return codecUtil.decodeList(userList);
        //return userList;
        }

    @Override
    public List<Map<String, Object>> userTabList(String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String,Object> param = new HashMap<>();
        param.put("siteid",codecUtil.decodePkNo(siteId));
        List<Map<String,Object>> userList = userDao.userList(param);
        for(int i=0;i<userList.size();i++){ //pk값 암호화
            String deUserNo = "";
            deUserNo = userList.get(i).get("NO").toString();
            String enUserNo = codecUtil.encodePkNo(deUserNo);
            userList.get(i).put("NO",enUserNo);
        }
        return codecUtil.decodeList(userList);
        //return userList;
    }

    @Override
    public String userInsert(HttpServletRequest request, UserDto userDto) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        userDto.setSiteid(siteId);
        userDto.setReguser(userNo);
        userDto.setEdtuser(userNo);
        String enCodePass = encoder.encode(userDto.getUserpassword());
        userDto.setEncodingUserDto();
        userDto.setUserpassword(enCodePass);
        String insertUserNo = userDao.userInsert(userDto);

        insertUserNo = codecUtil.encodePkNo(insertUserNo);

        return insertUserNo;
    }

    @Override
    public Map<String,Object> userDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        userNo = codecUtil.decodePkNo(userNo);
        UserDto userDto = new UserDto();
        userDto.setSiteid(siteId);
        userDto.setUserno(userNo);

        Map<String,Object> userInfo = userDao.userDetail(userDto);
        userInfo = codecUtil.decodeMap(userInfo);

        String encUserNo = codecUtil.encodePkNo(userInfo.get("USERNO").toString());
        userInfo.put("USERNO",encUserNo);

        return userInfo;
    }
    //사용자 업데이트
    @Override
    public void userUpdate(HttpServletRequest request, String userNo, UserDto userDto) throws UnsupportedEncodingException, GeneralSecurityException {

        userNo = codecUtil.decodePkNo(userNo);
        userDto.setEncodingUserDto();
        userDto.setUserno(userNo);
        if(userDto.getUserpassword() != null){
            String enCodePass = encoder.encode(userDto.getUserpassword());
            userDto.setUserpassword(enCodePass);
        }
        userDao.userUpdate(userDto);
    }
}
