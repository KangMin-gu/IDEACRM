package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UseLicenseDto;
import com.crud.ideacrm.dto.UserDto;
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
    public List<Map<String, Object>> licenseList(String siteId) {
        List<Map<String,Object>> licenseList = session.selectList("license.licenseList",siteId);
        return licenseList;
    }

    @Override
    public List<Map<String, Object>> allLicenseList() {
        List<Map<String,Object>> allLicenseList = session.selectList("license.allList");
        return allLicenseList;
    }

    @Override
    public void siteLicenseInsert(UseLicenseDto useLicenseDto) {
        session.insert("license.siteInsert",useLicenseDto);
    }

    @Override
    public List<Map<String, Object>> userLicenseList(UserDto userDto) {
        List<Map<String,Object>> userLicenseList = session.selectList("license.userLicenseList",userDto);
        return userLicenseList;
    }

    @Override
    public List<Map<String, Object>> useSiteLicenseList(int siteId) {
        List<Map<String,Object>> useSiteLicenseList = session.selectList("license.useSiteLicenseList",siteId);
        return useSiteLicenseList;
    }

    @Override
    public void menuReset(Map<String, Object> param) {
        session.update("license.menuReset",param);
    }

    @Override
    public void menuInsert(Map<String, Object> param) {
        session.insert("license.menuInsert",param);
    }

    @Override
    public List<Map<String, Object>> siteLicenseList(int siteId) {
        List<Map<String,Object>> siteLicenseList = session.selectList("license.siteLicenseList",siteId);
        return siteLicenseList;
    }
}
