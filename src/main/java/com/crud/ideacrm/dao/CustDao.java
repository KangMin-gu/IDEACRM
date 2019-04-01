package com.crud.ideacrm.dao;

import java.util.List;
import java.util.Map;

public interface CustDao {

    public List<Map<String,Object>> custList(Map<String,Object> searchPrm);

}
