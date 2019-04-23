package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UseLicenseDto;

import java.util.List;
import java.util.Map;

public interface LicenseDao {
    public List<Map<String,Object>> siteLicenseList(String siteId);
    public List<Map<String,Object>> allLicenseList();

    public void siteLicenseInsert(UseLicenseDto useLicenseDto);

}
