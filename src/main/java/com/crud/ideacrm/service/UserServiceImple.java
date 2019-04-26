package com.crud.ideacrm.service;


import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.UserDao;
import com.crud.ideacrm.dto.UserCtiDto;
import com.crud.ideacrm.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ParameterUtil parameterUtil;
// 사용자 관리 List
    @Override
    public List<Map<String, Object>> userList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String,Object> param = parameterUtil.searchParam(request);
        String deUserNo = "";
        List<Map<String,Object>> userList = userDao.userList(param);
        for(int i=0;i<userList.size();i++){ //pk값 암호화
            deUserNo = userList.get(i).get("NO").toString();
            String enUserNo = codecUtil.encodePkNo(deUserNo);
            userList.get(i).put("NO",enUserNo);
        }
        return codecUtil.decodeList(userList);
        }
// 회원사에 속한 사용자 List
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
    }
// 사용자 Insert
    @Override
    public String userInsert(HttpServletRequest request, UserDto userDto, UserCtiDto userCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        if(userDto.getMobile1() != null && userDto.getMobile2() != null && userDto.getMobile3() != null){
            String mobile = parameterUtil.columnUnion(userDto.getMobile1(),userDto.getMobile2(),userDto.getMobile3());
            userDto.setMobile(mobile);
        }
        if(userDto.getTelno1() != null && userDto.getTelno2() != null && userDto.getTelno3() != null){
            String telNo = parameterUtil.columnUnion(userDto.getTelno1(),userDto.getTelno2(),userDto.getTelno3());
            userDto.setTelno(telNo);
        }
        userDto.setSiteid(siteId);
        userDto.setReguser(userNo);
        userDto.setEdtuser(userNo);
        String enCodePass = encoder.encode(userDto.getUserpassword());
        String mobile = parameterUtil.columnUnion(userDto.getMobile1(),userDto.getMobile2(),userDto.getMobile3());
        userDto.setMobile(mobile);
        userDto.setEncodingUserDto();
        userDto.setUserpassword(enCodePass);
        String insertUserNo = userDao.userInsert(userDto);

        if(userCtiDto.getCtitelno() != null && !userCtiDto.getCtitelno().equals("")){
            userCtiDto.setUserno(insertUserNo);
            userDao.userCtiInsert(userCtiDto);
        }

        insertUserNo = codecUtil.encodePkNo(insertUserNo);

        return insertUserNo;
    }

    @Override
    public Map<String,Object> userDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        userNo = codecUtil.decodePkNo(userNo);
        UserDto userDto = new UserDto();
        userDto.setUserno(userNo);

        Map<String,Object> userInfo = userDao.userDetail(userDto);
        userInfo = codecUtil.decodeMap(userInfo);

        String encUserNo = codecUtil.encodePkNo(userInfo.get("USERNO").toString());
        userInfo.put("USERNO",encUserNo);

        return userInfo;
    }

    @Override
    public void userDelete(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        userNo = codecUtil.decodePkNo(userNo);
        int sessionUserNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        UserDto userDto = new UserDto();
        userDto.setUserno(userNo);
        userDto.setEdtuser(sessionUserNo);
        userDto.setSiteid(siteId);

        userDao.userDelete(userDto);
    }

    @Override
    public Map<String, Object> userCtiDetail(HttpServletRequest request, String userNo) throws UnsupportedEncodingException, GeneralSecurityException {
        userNo = codecUtil.decodePkNo(userNo);

        UserCtiDto userCtiDto = new UserCtiDto();
        userCtiDto.setUserno(userNo);

        Map<String,Object> userCtiDetail = userDao.userCtiDetail(userCtiDto);

        return userCtiDetail;
    }

    //사용자 업데이트
    @Override
    public void userUpdate(HttpServletRequest request, String userNo, UserDto userDto,UserCtiDto userCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int sessionUserNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        userNo = codecUtil.decodePkNo(userNo);

        String mobile = parameterUtil.columnUnion(userDto.getMobile1(),userDto.getMobile2(),userDto.getMobile3());
        userDto.setMobile(mobile);
        userDto.setSiteid(siteId);

        userDto.setEncodingUserDto();
        userDto.setUserno(userNo);
        if(userDto.getUserpassword() != null){
            String enCodePass = encoder.encode(userDto.getUserpassword());
            userDto.setUserpassword(enCodePass);
        }
        userDto.setEdtuser(sessionUserNo);
        userDao.userUpdate(userDto);

        if(userCtiDto.getCtitelno() != null && !userCtiDto.getCtitelno().equals("")){
            userCtiDto.setUserno(userNo);
            userCtiDto.setEdtuser(sessionUserNo);
            userDao.userCtiUpdate(userCtiDto);
        }
    }
}
