package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.*;

import java.util.List;
import java.util.Map;

public interface ServiceDao {
    // 서비스 List
    public List<Map<String,Object>> serviceList(Map<String,Object> param);
    // 서비스 Detail
    public Map<String,Object> serviceDetail(Map<String,Object> param);
    // 현상파악 Detail
    public Map<String,Object> rewardDetail(Map<String,Object> param);
    // 처리결과 Detail
    public Map<String,Object> ractDetail(Map<String,Object> param);
    // 서비스 Insert
    public String serviceInsert(ServiceDto serviceDto);
    // 현상파악 Insert
    public void rewardInsert(RewardDto rewardDto);
    // 처리결과 Insert
    public void ractInsert(RactDto ractDto);
    // 서비스 Update
    public void serviceUpdate(ServiceDto serviceDto);
    // 현상파악 Update
    public void rewardUpdate(RewardDto rewardDto);
    // 처리결과 Update
    public void ractUpdate(RactDto ractDto);
    // 서비스 단계 변경
    public void serviceStepUpdate(ServiceDto serviceDto);
    //서비스 삭제
    public void serviceDelete(ServiceDto serviceDto);
    // 처리결과 list
    public List<Map<String,Object>> ractList(Map<String,Object> param);
    // 서비스 이관 List
    public List<Map<String,Object>> conveyList(Map<String,Object> param);
    // 서비스 제품등록
    public void serviceProductInsert(Map<String,Object> param);
    // 서비스 제품 Detail
    public List<ProductDto> serviceProductRead(Map<String,Object> param);
    // 서비스 이관
    public void serviceDeliveryInsert(ServiceDeliveryDto serviceDeliveryDto);

    public List<Map<String,Object>> serviceCalList(RewardDto rewardDto);

    public List<Map<String, Object>> svCalRewardOwner(RewardDto rewardDto);

    public List<Map<String,Object>> calRewardOwnerList(Map<String,Object> param);

}
