package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ServiceDaoImple implements ServiceDao {

    @Autowired
    private SqlSession session;
    @Override
    public List<Map<String, Object>> serviceList(Map<String, Object> param) {

        List<Map<String,Object>> serviceList = session.selectList("service.serviceList",param);
        return serviceList;

    }

    @Override
    public Map<String, Object> serviceDetail(Map<String, Object> param) {
        Map<String,Object> serviceDetail = session.selectOne("service.serviceDetail",param);
        return serviceDetail;
    }

    @Override
    public Map<String, Object> rewardDetail(Map<String, Object> param) {
        Map<String,Object> rewardDetail = session.selectOne("service.rewardDetail",param);
        return rewardDetail;
    }

    @Override
    public Map<String, Object> ractDetail(Map<String, Object> param) {
        Map<String,Object> ractDetail = session.selectOne("service.ractDetail",param);
        return ractDetail;
    }

    @Override
    public String serviceInsert(ServiceDto serviceDto) {
        session.insert("service.serviceInsert",serviceDto);
        String serviceNo = serviceDto.getServiceno();
        return serviceNo;
    }

    @Override
    public void rewardInsert(RewardDto rewardDto) {
        session.insert("service.rewardInsert",rewardDto);

    }

    @Override
    public void ractInsert(RactDto ractDto) {
        session.insert("service.ractInsert",ractDto);

    }

    @Override
    public void serviceUpdate(ServiceDto serviceDto) {
        session.update("service.serviceUpdate",serviceDto);
    }

    @Override
    public void rewardUpdate(RewardDto rewardDto) {
        session.update("service.rewardUpdate",rewardDto);
    }

    @Override
    public void ractUpdate(RactDto ractDto) {
        session.update("service.ractUpdate",ractDto);
    }

    @Override
    public void serviceStepUpdate(ServiceDto serviceDto) {
        session.update("service.serviceStepUpdate",serviceDto);
    }

    @Override
    public void serviceDelete(ServiceDto serviceDto) {
        session.update("service.serviceDelete",serviceDto);

    }

    @Override
    public List<Map<String, Object>> ractList(Map<String, Object> param) {
        List<Map<String,Object>> ractList = session.selectList("service.ractList",param);
        return ractList;
    }

    @Override
    public List<Map<String, Object>> conveyList(Map<String, Object> param) {
        List<Map<String,Object>> conveyList = session.selectList("service.conveyList",param);
        return conveyList;
    }
    // VOC 서비스 제품등록
    @Override
    public void serviceProductInsert(Map<String, Object> param) {
        session.insert("service.serviceProductInsert",param);
    }

    @Override
    public List<ProductDto> serviceProductRead(Map<String,Object> param){
        List<ProductDto> serviceProductRead = session.selectList("service.serviceProductRead",param);

        return serviceProductRead;
    }

    @Override
    public void serviceDeliveryInsert(ServiceDeliveryDto serviceDeliveryDto) {
        session.insert("service.serviceDeliveryInsert",serviceDeliveryDto);
    }
}
