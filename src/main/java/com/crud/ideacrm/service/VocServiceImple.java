package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.dao.VocDao;
import com.crud.ideacrm.dto.BlackCustDto;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import com.crud.ideacrm.dto.EnCustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Service
public class VocServiceImple implements VocService {

    @Autowired
    CodecUtil codecUtil;
    @Autowired
    VocDao vocDao;

    //고객 수정 실행
    @Override
    public int vocCustUpdate(HttpServletRequest request, CustDto custDto, CustDenyDto custDenyDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        custDto.setSiteid(siteId);
        custDto.setEdituser(userNo);
        custDenyDto.setEdituser(userNo);

        CustDto enCustDto = new EnCustDto(custDto);
        String enCustNo = enCustDto.getCustno();
        String deCustNo = codecUtil.decodePkNo(enCustNo);
        String deRelCustNo = codecUtil.decodePkNo(enCustDto.getRelcustno());
        enCustDto.setRelcustno(deRelCustNo);
        enCustDto.setCustno(deCustNo);

        int res = vocDao.vocCustUpdate(enCustDto);//업데이트 dao호출
        //업데이트한 pk값 수신거부 dto에 설정
        String custno = enCustDto.getCustno();
        custDenyDto.setCustno(custno);
        //수신거부 dao 호출
        vocDao.vocCustDenyUpdate(custDenyDto);
        return res;
    }

    @Override
    public int vocBlackCustInsert(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        blackCustDto.setReguser(userno);
        blackCustDto.setReguser(siteid);
        String enCustNo = blackCustDto.getCustno();
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            blackCustDto.setCustno(deCustNo);
        }
        return vocDao.vocBlackCustInsert(blackCustDto);
    }

    @Override
    public int vocBlackCustDelete(HttpServletRequest request, BlackCustDto blackCustDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int userno = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int siteid = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        blackCustDto.setEdtuser(userno);
        blackCustDto.setSiteid(siteid);
        String enCustNo = blackCustDto.getCustno();
        if(enCustNo != null && !enCustNo.equals("0") && !enCustNo.equals("")){
            String deCustNo = codecUtil.decodePkNo(enCustNo);
            blackCustDto.setCustno(deCustNo);
        }
        return vocDao.vocBlackCustDelete(blackCustDto);
    }

}
