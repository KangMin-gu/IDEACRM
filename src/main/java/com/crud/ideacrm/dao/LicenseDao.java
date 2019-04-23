package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UseLicenseDto;
import com.crud.ideacrm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface LicenseDao {
    public List<Map<String,Object>> licenseList(String siteId);
    public List<Map<String,Object>> allLicenseList();

    public void siteLicenseInsert(UseLicenseDto useLicenseDto);

    public List<Map<String,Object>> userLicenseList(UserDto userDto);

    public List<Map<String,Object>> useSiteLicenseList(int siteId);

    public void menuReset(Map<String,Object> param);

    public void menuInsert(Map<String,Object> param);

    public List<Map<String,Object>> siteLicenseList(int siteId);

}
