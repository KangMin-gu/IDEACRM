package com.crud.ideacrm.dao;

import java.util.List;
import java.util.Map;

public interface ClientDao {
    public List<Map<String,Object>> clientList(Map<String,Object> searchParam);
}
