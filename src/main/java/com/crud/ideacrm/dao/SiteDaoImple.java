package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SiteDaoImple implements SiteDao {

    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> siteList(Map<String, Object> param) {

        List<Map<String,Object>> siteList = session.selectList("site.siteList",param);

        return siteList;
    }

    @Override
    public Map<String, Object> siteDetail(String siteId) {
        Map<String,Object> siteDetail = session.selectOne("site.siteDetail",siteId);
        return siteDetail;
    }

    @Override
    public Map<String, Object> siteCtiDetail(String siteId) {
        Map<String,Object> siteCtiDetail = session.selectOne("site.siteCti",siteId);
        return siteCtiDetail;
    }

    @Override
    public List<Map<String, Object>> siteKkoDetail(String siteId) {
        List<Map<String,Object>> siteKkoDetail = session.selectList("site.siteKko",siteId);
        return siteKkoDetail;
    }
}
