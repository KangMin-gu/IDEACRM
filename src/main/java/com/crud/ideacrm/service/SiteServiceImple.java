package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.dto.UploadDto;
import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.crud.util.Uplaod;
import com.crud.ideacrm.dao.SendDao;
import com.crud.ideacrm.dao.SiteDao;
import com.crud.ideacrm.dto.ChargeDto;
import com.crud.ideacrm.dto.CtiDto;
import com.crud.ideacrm.dto.KakaoDto;
import com.crud.ideacrm.dto.SiteDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SiteServiceImple implements SiteService{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private SiteDao siteDao;
    @Autowired
    private SendDao sendDao;
    @Autowired
    private CodecUtil codecUtil;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private Uplaod uplaod;

    @Override
    public List<Map<String, Object>> siteList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> siteList = siteDao.siteList(param);

        for(int i=0;i<siteList.size();i++){ //pk값 암호화
            String deSiteId = "";
            deSiteId = siteList.get(i).get("NO").toString();
            String enSiteId = codecUtil.encodePkNo(deSiteId);
            siteList.get(i).put("NO",enSiteId);
        }

        return codecUtil.decodeList(siteList);
        //return siteList;
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

    //cti웹소켓 통신 바인딩용
    @Override
    public Map<String, Object> ctiDetail(HttpServletRequest request) {
        String siteId = request.getSession().getAttribute("SITEID").toString();
        int userNo = (int)request.getSession().getAttribute("USERNO");
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("siteid",siteId);
        param.put("userno",userNo);

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("ctiInfo",siteDao.siteCtiDetail(siteId));
        resultMap.put("ctiUserInfo",siteDao.siteCtiUser(param));
        return resultMap;
    }

    @Override
    public String siteInsert(HttpServletResponse response,HttpServletRequest request, SiteDto siteDto, CtiDto ctiDto) throws UnsupportedEncodingException, GeneralSecurityException {
/*
        ParameterUtil parameterUtil = new ParameterUtil();
        String bsno = parameterUtil.columnUnion(siteDto.getBsno1(),siteDto.getBsno2(),siteDto.getBsno3());
        siteDto.setBsno(bsno);
*/
        siteDto.setEncodingSiteDto();
        String siteId = siteDao.siteInsert(siteDto);

        String EncodePass = encoder.encode(siteDto.getAdminpassword());
        siteDto.setAdminpassword(EncodePass);

        //파일업로드
        MultipartFile sFile = siteDto.getFile();
        if(sFile  != null  && sFile.isEmpty() == false){
            UploadDto uploadDto = uplaod.singleUpload(response, request, sFile);
            siteDto.setSitelogo(uploadDto.getImgpath());
        }

        siteDao.siteUserInsert(siteDto);

        if(siteId != null){
            ctiDto.setSiteid(siteId);
            String ctiIp = ctiDto.getIp();
            if(!ctiIp.equals("") ){
                ctiDto.setEncodingCtiDto();
                siteDao.ctiInsert(ctiDto);
            }
        }
        siteId = codecUtil.encodePkNo(siteId);
        return siteId;
    }

    @Override
    public void siteUpdate(HttpServletResponse response, HttpServletRequest request, String siteId, SiteDto siteDto, CtiDto ctiDto) throws UnsupportedEncodingException, GeneralSecurityException {
        String deSiteId = codecUtil.decodePkNo(siteId);
        siteDto.setSiteid(deSiteId);
        ctiDto.setSiteid(deSiteId);

        siteDto.setEncodingSiteDto();
        //파일업로드
        MultipartFile sFile = siteDto.getFile();
        if(sFile  != null  && sFile.isEmpty() == false){
            UploadDto uploadDto = uplaod.singleUpload(response, request, sFile);
            siteDto.setSitelogo(uploadDto.getImgpath());
        }
        siteDao.siteUpdate(siteDto);

        Map<String,Object> siteCtiDetail = siteDao.siteCtiDetail(deSiteId);

        if(siteCtiDetail == null){
            ctiDto.setEncodingCtiDto();
            siteDao.ctiInsert(ctiDto);
        }else{
            String ctiIp = siteCtiDetail.get("IP").toString();
            if(!ctiIp.equals(ctiDto.getIp())){
                ctiDto.setEncodingCtiDto();
                siteDao.ctiUpdate(ctiDto);
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
