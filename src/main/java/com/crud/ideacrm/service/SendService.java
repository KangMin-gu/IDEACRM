package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.dto.MailDto;
import com.crud.ideacrm.dto.InsideNoticeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public interface SendService {
    public void sendSms(HttpServletRequest request);
    public void sendEmail(HttpServletResponse response, HttpServletRequest request, MailDto mailDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public void sendInsideNotice (HttpServletResponse response, HttpServletRequest request, InsideNoticeDto insideNoticeDto) throws UnsupportedEncodingException, GeneralSecurityException;
}
