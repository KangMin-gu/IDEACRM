package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.dao.MailDao;
import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.crud.util.*;
import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dao.InsideNoticeDao;
import com.crud.ideacrm.dao.LoginDao;
import com.crud.ideacrm.dao.SendDao;
import com.crud.ideacrm.dto.InsideNoticeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

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
    @Autowired
    private ParameterUtil parameterUtil;

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
        String fromemail = codecUtil.decodePkNo(userInfo.get("EMAIL").toString());

        //파일업로드
        List<MultipartFile> mFile = mailDto.getFile();
        if(mFile  != null && mFile.size() > 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            mailDto.setFilesearchkey(fileSearchKey);
        }

        //dto에 인코딩 되어들어온 custno를 복호화 후 전달
        String deCustNo = codecUtil.decodePkNo(mailDto.getCustno());
        mailDto.setCustno(deCustNo);
        mailDto.setFromemail(fromemail);
        mailDao.emailSend(mailDto);

    }

    @Override
    public void sendInsideNotice(HttpServletResponse response, HttpServletRequest request, InsideNoticeDto insDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        insDto.setSiteid(siteId);
        insDto.setFromuserno(userNo);
        String content = insDto.getContent();
        String title = insDto.getTitle();

        MailDto mailDto = new MailDto();
        mailDto.setSubject(title);
        mailDto.setContent(content);
        mailDto.setLinkurl(insDto.getLinkurl());
        mailDto.setSiteid(siteId);
        mailDto.setUserno(userNo);
        //발송인정보
        Map<String, Object> userInfo = loginDao.userInfo(userNo);
        mailDto.setUsername(userInfo.get("USERNAME").toString());
        String cyfromemail = userInfo.get("EMAIL").toString();
        String defromemail = codecUtil.decodePkNo(cyfromemail);
        mailDto.setFromemail(defromemail);

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
            mailDto.setCstname(touserInfo.get("USERNAME").toString());
            String cytoemail = touserInfo.get("EMAIL").toString();
            String detoemail = codecUtil.decodePkNo(cytoemail);
            mailDto.setToemail(detoemail);
            mailDao.shareViewInsideNotice(mailDto);
        }
    }

    @Override
    public void sendSmsTemp(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> param = parameterUtil.searchParam(request);
        String msgTelNo = request.getSession().getAttribute("MSGTELNO").toString();
        if( param.get("custno") != null && param.get("custno") != ""){
            String custno = (String)param.get("custno");
            String deCustNo = codecUtil.decodePkNo(custno);
            param.put("custno",deCustNo);
        }else{
            return;
        }
        int lengthType = 0;
        param.put("callback",msgTelNo);

        if(param.get("lengthtype") != null){
            lengthType = Integer.parseInt(param.get("lengthtype").toString());
        }else{
            lengthType = 0;
        }

        if(lengthType == 1){
            sendDao.directSendLmsTemp(param);
        }else{
            sendDao.directSendSmsTemp(param);
        }
    }

    @Override
    public void sendKakaoTemp(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        Map<String,Object> param = parameterUtil.searchParam(request);
        int userNo = (int)request.getSession().getAttribute("USERNO");
        param.put("userno",userNo);
        if( param.get("custno") != null && param.get("custno") != "") {
            String custno = (String) param.get("custno");
            String deCustNo = codecUtil.decodePkNo(custno);
            param.put("custno", deCustNo);
        }
        sendDao.directSendKakaoTemp(param);
    }
}
