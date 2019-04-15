package com.crud.ideacrm.crud.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class UploadUtil {

    //파일서치키 생성
    public String fileSearchKey(HttpServletRequest request) {
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = time.format(calendar.getTime());
        String fileSearchKey = date+userNo;
        return fileSearchKey;
    }

    //파일사이즈체크
    public boolean whiteSizeFlag(long fileSize) {
        boolean whiteSizeFlag = false;
        long limitSize = 500000;
        if(fileSize < limitSize) {
            whiteSizeFlag = true;
        }
        return whiteSizeFlag;
    }


}
