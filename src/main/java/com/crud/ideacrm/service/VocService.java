package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.BlackCustDto;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public interface VocService {
    public int vocCustUpdate(HttpServletRequest request, CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public int vocBlackCustInsert(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException;
    public int vocBlackCustDelete(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException;
}
