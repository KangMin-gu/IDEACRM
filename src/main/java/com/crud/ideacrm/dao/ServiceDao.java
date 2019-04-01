package com.crud.ideacrm.dao;

import java.util.List;
import java.util.Map;

public interface ServiceDao {

    public List<Map<String,Object>> serviceList(Map<String,Object> param);

}
