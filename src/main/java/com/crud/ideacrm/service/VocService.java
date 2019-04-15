package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public interface VocService {
    public int vocCustUpdate(CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException;
}
