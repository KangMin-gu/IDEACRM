package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.RactDto;
import com.crud.ideacrm.dto.RewardDto;
import com.crud.ideacrm.dto.ServiceDto;
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
    public int serviceInsert(ServiceDto serviceDto) {
        int serviceNo = session.insert("service.serviceInsert",serviceDto);
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
}
