package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.ConveyDto;
import com.crud.ideacrm.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VocDaoImple implements VocDao {

    @Autowired
    private SqlSession session;

    //voc 고객 업데이트
    @Override
    public int vocCustUpdate(CustDto custDto) {
        return session.update("voc.vocCustUpdate",custDto);
    }

    //voc 고객 수신거부 업데이트
    @Override
    public int vocCustDenyUpdate(CustDenyDto custDenyDto) {
        return session.update("voc.vocCustDenyUpdate",custDenyDto);
    }

    @Override
    public int vocBlackCustInsert(BlackCustDto blackCustDto) {
        return session.insert("voc.vocBlackCustInsert",blackCustDto);
    }

    @Override
    public int vocBlackCustDelete(BlackCustDto blackCustDto) {
        return session.update("voc.vocBlackCustDelete",blackCustDto);
    }

    @Override
    public List<Map<String, Object>> blackHistoryList(Map<String, Object> prmMap) {
        return session.selectList("voc.blackHistoryList",prmMap);
    }

    @Override
    public List<Map<String, Object>> callBackHistoryList(Map<String, Object> prmMap) {
        return session.selectList("voc.callBackHistoryList",prmMap);
    }

    @Override
    public List<Map<String, Object>> vocCallBackList(Map<String, Object> prmMap) {
        return session.selectList("voc.vocCallBackList",prmMap);
    }

    @Override
    public int vocCallBackUpdate(Map<String, Object> prmMap) {
        return session.update("voc.vocCallBackUpdate",prmMap);
    }

    @Override
    public int vocCallBackHistoryInsert(Map<String, Object> prmMap) {
        return session.insert("voc.vocCallBackHistoryInsert",prmMap);
    }

    @Override
    public void vocRecInsert(Map<String, Object> prmMap) {
            session.insert("voc.vocrecInsert",prmMap);
    }

    @Override
    public void vocCallBackInsert(Map<String,Object> param) {
        session.insert("voc.vocCallBack",param);
    }

    //VOC 최근 서비스 한건 가져오기
    @Override
    public Map<String, Object> svTopDesc(Map<String, Object> param) {
        Map<String,Object> svTopList = session.selectOne("voc.topList",param);
        return svTopList;
    }
    //VOC 최근 상담예약 한건 가져오기
    @Override
    public Map<String, Object> svTopResv(Map<String, Object> param) {
        Map<String,Object> svTopResv = session.selectOne("voc.topReserv",param);
        return svTopResv;
    }
    //VOC 최근 이관 한건 가져오기
    @Override
    public Map<String, Object> svTopConvey(Map<String, Object> param) {
        Map<String,Object> svTopConvey = session.selectOne("voc.topConvey",param);
        return svTopConvey;
    }
    //VOC 최근 현상파악 한건 가져오기
    @Override
    public Map<String, Object> svTopReward(Map<String, Object> param) {
        Map<String,Object> svTopReward = session.selectOne("voc.topReward",param);
        return svTopReward;
    }
    @Override
    public List<ProductDto> svProductRead(Map<String,Object> param){
        List<ProductDto> svProductRead = session.selectList("voc.svProductRead",param);
        return svProductRead;
    }

    //서비스 Insert
    @Override
    public String svInsert(ServiceDto serviceDto) {
        session.insert("voc.svInsert",serviceDto);
        String serviceNo = serviceDto.getServiceno();
        return serviceNo;
    }

    // 진행단계 update
    @Override
    public void svStepUpdate(ServiceDto serviceDto) {
        session.update("voc.svStep",serviceDto);
    }

    @Override
    public void svReservInsert(Map<String, Object> param) {
        session.insert("voc.svReservInsert",param);
    }

    // 이관 추가
    @Override
    public void conveyInsert(ConveyDto conveyDto) {
        session.insert("voc.conveyInsert",conveyDto);
    }


}
