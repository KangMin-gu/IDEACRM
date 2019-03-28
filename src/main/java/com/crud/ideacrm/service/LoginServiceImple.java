package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.LoginManager;
import com.crud.ideacrm.dao.LoginDao;
import com.crud.ideacrm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Service
public class LoginServiceImple implements LoginService{
    //TEST
    @Autowired
    private LoginDao login;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public ModelAndView login(HttpServletResponse response, HttpServletRequest request, UserDto urDto) {
        LoginManager loginManager = LoginManager.getInstance();
        String location=request.getRequestURI();
        String url = request.getParameter("url");
        ModelAndView mView = new ModelAndView();
        StringBuffer buf = new StringBuffer();
        Map<String, Object> urInfo = login.getData(urDto.getUserid());
        if(urInfo != null) {
            String userId = urInfo.get("USERID").toString();
            String pwd = urDto.getUserpassword();
            boolean isValid = false;
            if(urInfo != null) {
                boolean isMatch=encoder.matches(pwd,urInfo.get("USERPASSWORD").toString());
                if(isMatch) {
                    isValid = true;
                    if(!loginManager.isUsing(userId)) {
                        loginManager.setSession(request.getSession(),urInfo.get("USERID").toString()); // 로그인정보 로그인매니저등록
                    }else {
                        loginManager.removeSession(userId);
                        buf.append("<script>alert('이전 사용자를 로그아웃 합니다. 재 로그인 해주세요.'); location.href='");
                        buf.append(location);
                        buf.append("';</script>");
                        response.setContentType("text/html; charset=UTF-8");
                        PrintWriter out;
                        try {
                            out = response.getWriter();
                            out.println(buf);
                            out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if(isValid){
                //사용자정보 세션 등록
                request.getSession().setAttribute("USERID", urInfo.get("USERID")); //사용자아이디
                request.getSession().setAttribute("USERNAME", urInfo.get("USERNAME")); //사용자이름
                request.getSession().setAttribute("USERNO", urInfo.get("USERNO")); //사용자 PK
                request.getSession().setAttribute("SITEID", urInfo.get("SITEID")); //사용자 사이트번호
                request.getSession().setAttribute("SITENAME", urInfo.get("SITENAME")); //사이트 이름
                request.getSession().setAttribute("CALLNAME", urInfo.get("CALLNAME")); //사이트 약어
                request.getSession().setAttribute("USERLANG", urInfo.get("USERLANG")); //사용자 언어
                request.getSession().setAttribute("CHKAUTH", urInfo.get("CHKAUTH")); //사용자 권한
                request.getSession().setAttribute("SITELOGO", urInfo.get("IMGPATH")); //회사 로고
                request.getSession().setAttribute("SIDESTATES","1");
                if(url != null) {
                    buf.append("<script>location.href='");
                    buf.append(url);
                    buf.append("';</script>");
                }else {
                    buf.append("<script>location.href='/';</script>");
                }
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out;
                try {
                    out = response.getWriter();
                    out.println(buf);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                if(url != null) {
                    buf.append("<script>alert('아이디 혹은 비밀번호가 틀립니다.');");
                    buf.append("location.href='/login?url=");
                    buf.append(url);
                    buf.append("';</script>");
                }else {
                    buf.append("<script>alert('아이디 혹은 비밀번호가 틀립니다.'); location.href='");
                    buf.append(location);
                    buf.append("';</script>");
                }
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out;
                try {
                    out = response.getWriter();
                    out.println(buf);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            if(url != null) {
                buf.append("<script>alert('아이디 혹은 비밀번호가 틀립니다.');");
                buf.append("location.href='/login?url=");
                buf.append(url);
                buf.append("';</script>");
            }else {
                buf.append("<script>alert('아이디 혹은 비밀번호가 틀립니다.'); location.href='");
                buf.append(location);
                buf.append("';</script>");
            }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out;
            try {
                out = response.getWriter();
                out.println(buf);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mView;
    }

}
