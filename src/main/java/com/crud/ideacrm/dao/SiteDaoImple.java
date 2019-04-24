package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.SiteCtiDto;
import com.crud.ideacrm.dto.KakaoDto;
import com.crud.ideacrm.dto.SiteDto;
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

    @Override
    public Map<String, Object> siteCtiUser(Map<String, Object> param) {
        return session.selectOne("site.siteCtiUser",param);
    }

    @Override
    public String siteInsert(SiteDto siteDto) {
        session.insert("site.siteInsert",siteDto);
        String siteId = siteDto.getSiteid();
        return siteId;
    }

    @Override
    public void ctiInsert(SiteCtiDto siteCtiDto) {
        session.insert("site.ctiInsert",siteCtiDto);
    }

    @Override
    public void kakaoInsert(KakaoDto kakaoDto) {
        session.insert("site.kakaoInsert",kakaoDto);
    }

    @Override
    public void siteUserInsert(SiteDto siteDto) {
        session.insert("site.siteUserInsert",siteDto);
    }

    @Override
    public void siteUpdate(SiteDto siteDto) {
        session.update("site.siteUpdate",siteDto);
    }

    @Override
    public void siteDelete(String siteId) {
        session.update("site.siteDelete",siteId);
    }

    @Override
    public void ctiUpdate(SiteCtiDto siteCtiDto) {
        session.update("site.ctiUpdate",siteCtiDto);
    }

    @Override
    public int siteMasterPassword(Map<String, Object> param) {
        int cnt = session.update("site.siteMasterPassword",param);
        return cnt;
    }
}
