package com.crud.ideacrm.service;

import java.util.List;
import java.util.Map;

public interface CustService {

    public List<Map<String,Object>> custList(Map<String,Object> searchPrm);
}
