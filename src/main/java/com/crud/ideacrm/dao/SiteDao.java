package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CtiDto;
import com.crud.ideacrm.dto.KakaoDto;
import com.crud.ideacrm.dto.SiteDto;

import java.util.List;
import java.util.Map;

public interface SiteDao {

    public List<Map<String,Object>> siteList(Map<String,Object> param);
    public Map<String,Object> siteDetail(String siteId);
    public Map<String,Object> siteCtiDetail(String siteId);
    public List<Map<String,Object>> siteKkoDetail(String siteId);

    public String siteInsert(SiteDto siteDto);
    public void ctiInsert(CtiDto ctiDto);
    public void kakaoInsert(KakaoDto kakaoDto);

    public void siteUserInsert(SiteDto siteDto);

    public void siteUpdate(SiteDto siteDto);

    public void siteDelete(String siteId);

    public void ctiUpdate(CtiDto ctiDto);
}
