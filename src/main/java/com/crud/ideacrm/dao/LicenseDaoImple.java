package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LicenseDaoImple implements LicenseDao{

    @Autowired
    private SqlSession session;
    @Override
    public List<Map<String, Object>> userLicenseList(String siteId) {
        List<Map<String,Object>> siteLicenseList = session.selectList("license.siteLicenseList",siteId);
        return siteLicenseList;
    }

    @Override
    public List<Map<String, Object>> allLicenseList() {
        List<Map<String,Object>> allLicenseList = session.selectList("license.allList");
        return allLicenseList;
    }
}
