package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.dao.ServiceDao;
import com.crud.ideacrm.dto.RactDto;
import com.crud.ideacrm.dto.RewardDto;
import com.crud.ideacrm.dto.ServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ServiceServiceImple implements ServiceService{

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public List<Map<String,Object>> serviceList(HttpServletRequest request){
        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);

        List<Map<String,Object>> svList = serviceDao.serviceList(param);

        return svList;
    }

    @Override
    public ModelAndView serviceDetail(HttpServletRequest request, int serviceNo) {
        ModelAndView mView = new ModelAndView();

        ParameterUtil parameterUtil = new ParameterUtil();

        Map<String,Object> param = parameterUtil.searchParam(request);
        param.put("serviceno",serviceNo);

        Map<String,Object> serviceInfo = serviceDao.serviceDetail(param);
        Map<String,Object> rewardInfo = serviceDao.rewardDetail(param);
        Map<String,Object> ractInfo = serviceDao.ractDetail(param);
        //List<ProductDto> product = serviceDao.svProductRead(param);

       // mView.addObject("product",product);
        mView.addObject("serviceInfo", serviceInfo);
        mView.addObject("rewardInfo", rewardInfo);
        mView.addObject("ractInfo", ractInfo);

        return mView;
    }

    @Override
    public int serviceInsertUpdate(HttpServletRequest request, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto) {
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
        int serviceNo = serviceDto.getServiceno();
        if(serviceNo == 0) {
            serviceDto.setIsdelete(0);
            serviceNo = serviceDao.serviceInsert(serviceDto);
        }

        String visitDate = rewardDto.getVisitdate();

        int rewardNo = rewardDto.getRewardno();

        // 방문 일정이 잡히면 현상파악을 Insert 하게됨.
        if(visitDate != null) {
            if(visitDate.length() > 0) {
                if(rewardNo != 0) {
                    serviceDao.rewardUpdate(rewardDto);
                }else {
                    rewardDto.setServiceno(serviceNo);
                    rewardDto.setReguser(userNo);
                    serviceDao.rewardInsert(rewardDto);
                    serviceDto.setServicestep(3);
                    serviceDao.serviceStepUpdate(serviceDto);
                }
            }
        }

        String ractDate = ractDto.getRactdate();
        int ractNo = ractDto.getRactno();

        if(ractDate.length() > 0) {
            if(ractNo != 0) {
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
                        //serviceDao.svProductInsert(map);
                    }
                }
            }
        }
        return serviceNo;

    }
}
