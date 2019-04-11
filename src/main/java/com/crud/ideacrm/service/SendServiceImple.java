package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.SendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class SendServiceImple implements SendService {

    @Autowired
    private SendDao sendDao;

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
}
