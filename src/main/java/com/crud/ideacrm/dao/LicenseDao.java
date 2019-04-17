package com.crud.ideacrm.dao;

import java.util.List;
import java.util.Map;

public interface LicenseDao {
    public List<Map<String,Object>> userLicenseList(String siteId);
    public List<Map<String,Object>> allLicenseList();

}
