package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.dao.MailDao;
import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.crud.util.*;
import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dao.InsideNoticeDao;
import com.crud.ideacrm.dao.LoginDao;
import com.crud.ideacrm.dao.SendDao;
import com.crud.ideacrm.dto.InsideNoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendServiceImple implements SendService {

    @Autowired
    private SendDao sendDao;
    @Autowired
    private Uplaod uplaod;
    @Autowired
    private MailDao mailDao;
    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private InsideNoticeDao insnd;
    @Autowired
    private LoginDao loginDao;

    @Override
    public void sendSms(HttpServletRequest request) {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);
        String msgTelNo = request.getSession().getAttribute("MSGTELNO").toString();
        int lengthType = 0;
        param.put("callback",msgTelNo);

        if(param.get("lengthtype") != null){
            lengthType = Integer.parseInt(param.get("lengthtype").toString());
        }else{
            lengthType = 0;
        }

        if(lengthType == 1){
            sendDao.directSendLms(param);
        }else{
            sendDao.directSendSms(param);
        }
    }

    @Override
    public void sendEmail(HttpServletResponse response, HttpServletRequest request, MailDto mailDto) throws UnsupportedEncodingException, GeneralSecurityException {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        mailDto.setSiteid(siteId);
        mailDto.setUserno(userNo);
        Map<String, Object> userInfo = loginDao.userInfo(userNo);
        String formemail = codecUtil.decodePkNo(userInfo.get("EMAIL").toString());

        //파일업로드
        List<MultipartFile> mFile = mailDto.getFile();
        if(mFile  != null && mFile.size() > 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            mailDto.setFilesearchkey(fileSearchKey);
        }

        //dto에 인코딩 되어들어온 custno를 복호화 후 전달
        String deCustNo = codecUtil.decodePkNo(mailDto.getCustno());
        mailDto.setCustno(deCustNo);
        mailDto.setFromemail(formemail);
        mailDao.emailSend(mailDto);

    }

    @Override
    public void sendInsideNotice(HttpServletResponse response, HttpServletRequest request, InsideNoticeDto insDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        insDto.setSiteid(siteId);
        insDto.setFromuserno(userNo);
        MailDto mailDto = new MailDto();
        mailDto.setUserno(userNo);
        //발송인정보
        Map<String, Object> userInfo = loginDao.userInfo(userNo);
        mailDto.setFromemail(userInfo.get("EMAIL").toString());
        mailDto.setSubject(insDto.getTitle());
        mailDto.setContent(insDto.getContent());


        //파일업로드
        List<MultipartFile> mFile = insDto.getFile();
        if(mFile  != null && mFile.size() > 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            insDto.setFilesearchkey(fileSearchKey);
            mailDto.setFilesearchkey(fileSearchKey);
        }

        //통지등록
        int noticeId =  insnd.send(insDto);
        insDto.setNoticeid(noticeId);

        String toUserList[] = request.getParameterValues("touser");
        for(String a : toUserList) {
            int toUserNo = Integer.parseInt(a);
            insDto.setTouserno(toUserNo);

            //수신인 통지발송
            insnd.to(insDto);

            //수신인 이메일취득
            Map<String, Object> touserInfo = loginDao.userInfo(toUserNo);
            String cytoemail = touserInfo.get("EMAIL").toString();
            String detoemail = codecUtil.decodePkNo(cytoemail);
            mailDto.setToemail(detoemail);
            mailDao.shareViewInsideNotice(mailDto);
        }


    }
}
