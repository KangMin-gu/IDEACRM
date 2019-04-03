package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

import java.util.List;
import java.util.Map;

public interface CustDao {

    public List<Map<String,Object>> custList(Map<String,Object> searchPrm);
    public Map<String,Object> custDetail(CustDto custDto);

    public int custInsert(CustDto custDto);
    public int custDenyInsert(CustDenyDto custDenyDto);

    public int mergeCliCust(CustDto custDto);
}
