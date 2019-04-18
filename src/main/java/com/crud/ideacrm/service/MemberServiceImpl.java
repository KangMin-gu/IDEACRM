package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.dao.MailDao;
import com.crud.ideacrm.dao.MemberDao;
import com.crud.ideacrm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MailDao mailDao;

    @Override
    public ModelAndView userInfo(HttpServletRequest request, int userId) {
        ModelAndView mView = new ModelAndView();
        Map<String, Object> userInfo = memberDao.userInfo(userId);
        mView.addObject("userInfo",userInfo);
        return mView;
    }

    @Override
    public void userPwdReset(HttpServletRequest request) {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int edtUserNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        //비밀번호초기화
        StringBuffer resetPwd = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    // a-z
                    resetPwd.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    // A-Z
                    resetPwd.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    // 0-9
                    resetPwd.append((rnd.nextInt(10)));
                    break;
            }
        }

        UserDto userDto = new UserDto();
        String pwd = resetPwd.toString();
        //비밀번호 변경
        userDto.setUserpassword(pwd);

        //비밀번호 변경 이메일 로직 프로시저 생성 발송 예정
        Map<String, Object> userVal = new HashMap<>();
        userVal.put("siteid",siteId);
        userVal.put("touserno",userNo);
        userVal.put("fromuserno",edtUserNo);
        userVal.put("pwd",pwd);
        mailDao.PwdChangeMailProcedure(userVal);

        //비밀번호암호화
        String hashPwd = encoder.encode(pwd);
        userDto.setUserpassword(hashPwd);
        //수정 유저
        userDto.setEdtuser(edtUserNo);
        //변경대상자
        userDto.setUserno(Integer.toString(userNo));
        userDto.setSiteid(siteId);

        //유저 비밀번호 업데이트
        memberDao.memeberChangePwd(userDto);

    }
}
