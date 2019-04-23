package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.SendDao;
import com.crud.ideacrm.dao.SiteDao;
import com.crud.ideacrm.dto.ChargeDto;
import com.crud.ideacrm.dto.SiteCtiDto;
import com.crud.ideacrm.dto.SiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SiteServiceImple implements SiteService{

    @Autowired
    private SiteDao siteDao;
    @Autowired
    private SendDao sendDao;
    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ParameterUtil parameterUtil;

    @Override
    public List<Map<String, Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> siteList = siteDao.siteList(param);

        for(int i=0;i<siteList.size();i++){ //pk값 암호화
            String deSiteId = "";
            deSiteId = siteList.get(i).get("NO").toString();
            String enSiteId = codecUtil.encodePkNo(deSiteId);
            siteList.get(i).put("NO",enSiteId);
        }

        return codecUtil.decodeList(siteList);
    }

    @Override
    public ModelAndView siteDetail(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {
        ModelAndView mView = new ModelAndView();
        String deSiteId = codecUtil.decodePkNo(siteId);//복호화 후 전달

        Map<String,Object> siteDetail = siteDao.siteDetail(deSiteId);
        Map<String,Object> siteCtiDetail = siteDao.siteCtiDetail(deSiteId);
        List<Map<String,Object>> siteKkoDetail = siteDao.siteKkoDetail(deSiteId);
        siteDetail.put("SITEID",siteId);
        siteDetail = codecUtil.decodeMap(siteDetail);//암호화 필드 복호화작업
        mView.addObject("siteInfo",siteDetail);
        mView.addObject("ctiInfo",siteCtiDetail);
        mView.addObject("kkoInfo",siteKkoDetail);
        return mView;
    }

    @Override
    public String siteInsert(HttpServletRequest request, SiteDto siteDto, SiteCtiDto siteCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {

        if(siteDto.getBsno1() != null && siteDto.getBsno2() != null && siteDto.getBsno3() != null){
            String bsNo = parameterUtil.columnUnion(siteDto.getBsno1(),siteDto.getBsno2(),siteDto.getBsno3());
            siteDto.setBsno(bsNo);
        }
        if(siteDto.getIncno1() != null && siteDto.getIncno2() != null){
            String incNo = parameterUtil.columnUnion(siteDto.getIncno1(),siteDto.getIncno2());
            siteDto.setIncno(incNo);
        }
        if(siteDto.getMobile1() != null && siteDto.getMobile2() != null && siteDto.getMobile3() != null){
            String mobile = parameterUtil.columnUnion(siteDto.getMobile1(),siteDto.getMobile2(),siteDto.getMobile3());
            siteDto.setMobile(mobile);
        }
        if(siteDto.getFaxtel1() != null && siteDto.getFaxtel2() != null && siteDto.getFaxtel3() != null){
            String faxtel = parameterUtil.columnUnion(siteDto.getFaxtel1(),siteDto.getFaxtel2(),siteDto.getFaxtel3());
            siteDto.setFaxtel(faxtel);
        }
        if(siteDto.getTelno1() != null && siteDto.getTelno2() != null && siteDto.getTelno3() != null){
            String telno = parameterUtil.columnUnion(siteDto.getTelno1(),siteDto.getTelno2(),siteDto.getTelno3());
            siteDto.setTelno(telno);
        }

        siteDto.setEncodingSiteDto();
        String siteId = siteDao.siteInsert(siteDto);

        String EncodePass = encoder.encode(siteDto.getAdminpassword());
        siteDto.setAdminpassword(EncodePass);

        siteDao.siteUserInsert(siteDto);

        if(siteId != null){
            siteCtiDto.setSiteid(siteId);
            String ctiIp = siteCtiDto.getIp();
            if(!ctiIp.equals("") ){
                siteCtiDto.setEncodingCtiDto();
                siteDao.ctiInsert(siteCtiDto);
            }
        }
        siteId = codecUtil.encodePkNo(siteId);
        return siteId;
    }

    @Override
    public void siteUpdate(HttpServletRequest request, String siteId, SiteDto siteDto, SiteCtiDto siteCtiDto) throws UnsupportedEncodingException, GeneralSecurityException {

        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        if(siteDto.getBsno1() != null && siteDto.getBsno2() != null && siteDto.getBsno3() != null){
            String bsNo = parameterUtil.columnUnion(siteDto.getBsno1(),siteDto.getBsno2(),siteDto.getBsno3());
            siteDto.setBsno(bsNo);
        }
        if(siteDto.getIncno1() != null && siteDto.getIncno2() != null){
            String incNo = parameterUtil.columnUnion(siteDto.getIncno1(),siteDto.getIncno2());
            siteDto.setIncno(incNo);
        }
        if(siteDto.getMobile1() != null && siteDto.getMobile2() != null && siteDto.getMobile3() != null){
            String mobile = parameterUtil.columnUnion(siteDto.getMobile1(),siteDto.getMobile2(),siteDto.getMobile3());
            siteDto.setMobile(mobile);
        }
        if(siteDto.getFaxtel1() != null && siteDto.getFaxtel2() != null && siteDto.getFaxtel3() != null){
            String faxtel = parameterUtil.columnUnion(siteDto.getFaxtel1(),siteDto.getFaxtel2(),siteDto.getFaxtel3());
            siteDto.setFaxtel(faxtel);
        }
        if(siteDto.getTelno1() != null && siteDto.getTelno2() != null && siteDto.getTelno3() != null){
            String telno = parameterUtil.columnUnion(siteDto.getTelno1(),siteDto.getTelno2(),siteDto.getTelno3());
            siteDto.setTelno(telno);
        }

        String deSiteId = codecUtil.decodePkNo(siteId);
        siteDto.setSiteid(deSiteId);
        siteDto.setEdtuser(userNo);
        siteCtiDto.setSiteid(deSiteId);
        siteCtiDto.setEdtuser(userNo);

        siteDto.setEncodingSiteDto();
        siteDao.siteUpdate(siteDto);

        Map<String,Object> siteCtiDetail = siteDao.siteCtiDetail(deSiteId);

        if(siteCtiDetail == null){
            if(!siteCtiDto.getIp().equals("")){
                siteCtiDto.setEncodingCtiDto();
                siteDao.ctiInsert(siteCtiDto);
            }
        }else{
            String ctiIp = siteCtiDetail.get("IP").toString();
            if(!ctiIp.equals(siteCtiDto.getIp())){
                siteCtiDto.setEncodingCtiDto();
                siteDao.ctiUpdate(siteCtiDto);
            }
        }
    }

    @Override
    public void siteDelete(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

        String decSiteId = codecUtil.decodePkNo(siteId);
        siteDao.siteDelete(decSiteId);
    }

    @Override
    public Map<String, Object> totalMoney(HttpServletRequest request, String siteId) throws UnsupportedEncodingException, GeneralSecurityException {

        siteId = codecUtil.decodePkNo(siteId);

        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);

        Map<String,Object> total = new HashMap<>();

        // 발송 횟수
        int cntSms = sendDao.totalSms(param);
        int cntMms = sendDao.totalMms(param);
        int cntLms = sendDao.totalLms(param);
        int cntKakao = sendDao.totalKakao(param);
        int cntEmail = sendDao.totalEmail(param);


        // 발송 단가
        ChargeDto chargeType = sendDao.chareType(siteId);

        // 발송 금액
        if(chargeType != null){
            int smsTotal = chargeType.getSmscharge() * cntSms;
            int mmsTotal = chargeType.getMmscharge() * cntMms;
            int lmsTotal = chargeType.getLmscharge()* cntLms;
            int kakaoTotal = chargeType.getKakaocharge() * cntKakao;
            int emailTotal = chargeType.getEmailcharge() * cntEmail;

            int mergeMoney = smsTotal + mmsTotal + lmsTotal + kakaoTotal + emailTotal;

            // 발송 횟수
            total.put("smsCnt",cntSms);
            total.put("mmsCnt",cntMms);
            total.put("lmsCnt",cntLms);
            total.put("kakaoCnt",cntKakao);
            total.put("emailCnt",cntEmail);

            // 발송 금액
            total.put("smsTotal",smsTotal);
            total.put("mmsTotal",mmsTotal);
            total.put("lmsTotal",lmsTotal);
            total.put("kakaoTotal",kakaoTotal);
            total.put("emailTotal",emailTotal);

            // 발송 총금액
            total.put("mergeMoney",mergeMoney);

            // 발송 단가
            total.put("chargeType",chargeType);


        }

        return total;
    }
}
