package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.SiteCtiDto;
import com.crud.ideacrm.dto.KakaoDto;
import com.crud.ideacrm.dto.SiteDto;

import java.util.List;
import java.util.Map;

public interface SiteDao {

    public List<Map<String,Object>> siteList(Map<String,Object> param);
    public Map<String,Object> siteDetail(String siteId);
    public Map<String,Object> siteCtiDetail(String siteId);
    public List<Map<String,Object>> siteKkoDetail(String siteId);
    public Map<String,Object> siteCtiUser(Map<String,Object> param);

    public String siteInsert(SiteDto siteDto);
    public void ctiInsert(SiteCtiDto siteCtiDto);
    public void kakaoInsert(KakaoDto kakaoDto);

    public void siteUserInsert(SiteDto siteDto);

    public void siteUpdate(SiteDto siteDto);

    public void siteDelete(String siteId);

    public void ctiUpdate(SiteCtiDto siteCtiDto);
}
