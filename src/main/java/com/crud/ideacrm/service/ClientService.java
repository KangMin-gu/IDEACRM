package com.crud.ideacrm.service;

import java.util.List;
import java.util.Map;

public interface ClientService {
    public List<Map<String,Object>> clientList(Map<String,Object> searchParam);
}
