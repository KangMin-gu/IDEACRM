package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.ServiceDao;
import com.crud.ideacrm.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.*;

@Service
public class ServiceServiceImple implements ServiceService{

    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private CodecUtil codecUtil;

    @Override
    public List<Map<String,Object>> serviceList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> svList = serviceDao.serviceList(param);

        for(int i=0;i<svList.size();i++){ //pk값 암호화
            String deServiceNo = "";
            deServiceNo = svList.get(i).get("NO").toString();
            String enSiteId = codecUtil.encodePkNo(deServiceNo);
            svList.get(i).put("NO",enSiteId);
        }

        return codecUtil.decodeList(svList);
    }

    @Override
    public Map<String,Object> serviceDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {

        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        param.put("serviceno",serviceNo);

        Map<String,Object> serviceInfo = serviceDao.serviceDetail(param);

        serviceNo = codecUtil.encodePkNo(serviceInfo.get("SERVICENO").toString());
        serviceInfo.put("SERVICENO",serviceNo);
        serviceInfo = codecUtil.decodeMap(serviceInfo);//암호화 필드 복호화작업
        return serviceInfo;
    }

    @Override
    public Map<String, Object> rewardDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        param.put("serviceno",serviceNo);

        Map<String,Object> rewardInfo = serviceDao.rewardDetail(param);
        if(rewardInfo != null){
            rewardInfo = codecUtil.decodeMap(rewardInfo);//암호화 필드 복호화작업
        }
        return rewardInfo;
    }

    @Override
    public Map<String, Object> ractDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        param.put("serviceno",serviceNo);

        Map<String,Object> ractInfo = serviceDao.ractDetail(param);
        return ractInfo;
    }

    @Override
    public List<ProductDto> productDetail(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        param.put("serviceno",serviceNo);
        List<ProductDto> product = serviceDao.serviceProductRead(param);
        return product;
    }

    @Override
    public String serviceInsertUpdate(HttpServletRequest request, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> search = parameterUtil.searchParam(request);

        serviceDto.setSiteid(siteId);
        serviceDto.setEdtuser(userNo);
        serviceDto.setReguser(userNo);
        rewardDto.setSiteid(siteId);
        rewardDto.setEdtuser(userNo);
        ractDto.setSiteid(siteId);
        ractDto.setEdtuser(userNo);
/*
        int serviceFileSize = multipartHttpServletRequest.getFiles("servicefile").size();
        int rewardFileSize = multipartHttpServletRequest.getFiles("rewardfile").size();
        int ractFileSize = multipartHttpServletRequest.getFiles("ractfile").size();
        List<MultipartFile> serviceFileUpload = null;
        List<MultipartFile> rewardFileUpload = null;
        List<MultipartFile> ractFileUpload = null;
        MultipartFile sFile = null;

        if(serviceFileSize > 0) {
            serviceFileUpload = multipartHttpServletRequest.getFiles("servicefile");
            int serviceFileUploadLength = serviceFileUpload.get(0).getOriginalFilename().length();
            if(serviceFileUploadLength > 0) {
                String fileSearchKey = crud.fileSearchKey(request);
                crud.fileUpload(response, multipartHttpServletRequest, serviceFileUpload, sFile, fileSearchKey);
                serviceDto.setFilesearchkey(fileSearchKey);
            }
        }
        if(rewardFileSize > 0) {
            rewardFileUpload = multipartHttpServletRequest.getFiles("rewardfile");
            int rewardFileUploadLength = rewardFileUpload.get(0).getOriginalFilename().length();
            if(rewardFileUploadLength > 0) {
                String fileSearchKey = crud.fileSearchKey(request);
                crud.fileUpload(response, multipartHttpServletRequest, rewardFileUpload, sFile, fileSearchKey);
                rewardDto.setFilesearchkey(fileSearchKey);
            }
        }
        if(ractFileSize > 0) {
            ractFileUpload = multipartHttpServletRequest.getFiles("ractfile");
            int ractFileUploadLength = ractFileUpload.get(0).getOriginalFilename().length();
            if(ractFileUploadLength > 0) {
                String fileSearchKey = crud.fileSearchKey(request);
                crud.fileUpload(response, multipartHttpServletRequest, ractFileUpload, sFile, fileSearchKey);
                ractDto.setFilesearchkey(fileSearchKey);
            }
        }
*/

        String serviceNo = serviceDto.getServiceno();

        String custNo = codecUtil.decodePkNo(serviceDto.getCustno());
        serviceDto.setCustno(custNo);
        if(serviceNo == null) {
            serviceDto.setIsdelete(0);
            serviceNo = serviceDao.serviceInsert(serviceDto);
            serviceDto.setServicestep(1);
            serviceDto.setServiceno(serviceNo);
            serviceDao.serviceStepUpdate(serviceDto);
        }else{
            serviceNo = codecUtil.decodePkNo(serviceNo);
            serviceDto.setServiceno(serviceNo);
        }

        String visitDate = rewardDto.getVisitdate();

        int rewardNo = rewardDto.getRewardno();

        // 방문 일정이 잡히면 현상파악을 Insert 하게됨.
        if(visitDate != null) {
            if(visitDate.length() > 0) {
                if(rewardNo != 0) {
                    rewardDto.setServiceno(serviceNo);
                    rewardDto.setEncodingRewardDto();
                    serviceDao.rewardUpdate(rewardDto);
                }else {
                    rewardDto.setEncodingRewardDto();
                    rewardDto.setServiceno(serviceNo);
                    rewardDto.setReguser(userNo);
                    serviceDao.rewardInsert(rewardDto);
                    serviceDto.setServicestep(2);
                    serviceDao.serviceStepUpdate(serviceDto);
                }
            }
        }

        String ractDate = ractDto.getRactdate();
        int ractNo = ractDto.getRactno();

        if(ractDate == null || ractDate =="") {
        }else{
            if(ractNo != 0) {
                ractDto.setServiceno(serviceNo);
                serviceDao.ractUpdate(ractDto);
            }else{
                ractDto.setServiceno(serviceNo);
                ractDto.setReguser(userNo);
                serviceDao.ractInsert(ractDto);
                serviceDto.setServicestep(3);
                serviceDao.serviceStepUpdate(serviceDto);
            }
        }

        int cnt = 0;
        Map<String,Object> map = new HashMap();
        TreeMap<String,Object> treeMap = new TreeMap<String,Object>(search);

        String key;
        String value;

        Iterator<String> keyiterator = treeMap.keySet().iterator();
        map.put("siteid", siteId);
        map.put("reguser", userNo);
        map.put("edtuser", userNo);
        map.put("serviceno", serviceNo);
        while(keyiterator.hasNext()) {
            key = keyiterator.next().toString();
            if(search.get(key) != null) {
                value = search.get(key).toString();
                if(key.contains("product")) {
                    cnt ++;
                    if(cnt == 1) {
                        map.put("productb", value);
                    }else if(cnt ==2) {
                        map.put("productm", value);
                    }else if(cnt ==3) {
                        map.put("products", value);
                        cnt = 0;
                        serviceDao.serviceProductInsert(map);
                    }
                }
            }
        }
        serviceNo = codecUtil.encodePkNo(serviceNo);
        return serviceNo;

    }

    @Override
    public void serviceDelete(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ServiceDto serviceDto = new ServiceDto();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        serviceDto.setSiteid(siteId);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        serviceDto.setServiceno(serviceNo);

        serviceDao.serviceDelete(serviceDto);
    }

    @Override
    public List<Map<String, Object>> ractList(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {

        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        param.put("serviceno",serviceNo);

        List<Map<String,Object>> ractList = serviceDao.ractList(param);

        return ractList;
    }

    @Override
    public List<Map<String, Object>> conveyList(HttpServletRequest request, String serviceNo) throws UnsupportedEncodingException, GeneralSecurityException {
        ParameterUtil parameterUtil = new ParameterUtil();
        Map<String,Object> param = parameterUtil.searchParam(request);
        serviceNo = codecUtil.decodePkNo(serviceNo);
        param.put("serviceno",serviceNo);

        List<Map<String,Object>> conveyList = serviceDao.conveyList(param);
        return conveyList;
    }

    @Override
    public String serviceDeliveryInsert(HttpServletRequest request, ServiceDeliveryDto serviceDeliveryDto) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        String encServiceNo = serviceDeliveryDto.getServiceno();
        String serviceNo = codecUtil.decodePkNo(serviceDeliveryDto.getServiceno());

        serviceDeliveryDto.setSiteid(siteId);
        serviceDeliveryDto.setReguser(userNo);
        serviceDeliveryDto.setEdtuser(userNo);

        serviceDeliveryDto.setServiceno(serviceNo);

        serviceDao.serviceDeliveryInsert(serviceDeliveryDto);
        return encServiceNo;
    }

    @Override
    public ModelAndView serviceCalList(HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        ModelAndView mView = new ModelAndView();
        RewardDto rewardDto = new RewardDto();


        rewardDto.setSiteid(siteId);

        List<Map<String,Object>> serviceCalList = serviceDao.serviceCalList(rewardDto);

        for(int i=0;i<serviceCalList.size();i++){ //pk값 암호화
            String deServiceNo = "";
            deServiceNo = serviceCalList.get(i).get("id").toString();
            String enSiteId = codecUtil.encodePkNo(deServiceNo);
            serviceCalList.get(i).put("id",enSiteId);
        }


        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(serviceCalList);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

        mView.addObject("schList",jsonStr);//캘린더 스케쥴
        mView.addObject("svSchList",serviceCalList);//캘린더 틀 목록.

        return mView;
    }
}
