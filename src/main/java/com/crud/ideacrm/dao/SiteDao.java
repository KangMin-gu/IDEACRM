package com.crud.ideacrm.dao;

import java.util.List;
import java.util.Map;

public interface SiteDao {

    public List<Map<String,Object>> siteList(Map<String,Object> param);
    public Map<String,Object> siteDetail(String siteId);
    public Map<String,Object> siteCtiDetail(String siteId);
    public List<Map<String,Object>> siteKkoDetail(String siteId);
}
