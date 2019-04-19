package com.crud.ideacrm.excel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public interface CustExcel {
    public void custListExcelDownload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, GeneralSecurityException;
}
