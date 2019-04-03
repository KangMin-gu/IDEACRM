package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

import java.util.List;
import java.util.Map;

public interface CustService {

    public List<Map<String,Object>> custList(Map<String,Object> searchPrm);
    public Map<String,Object> custDetail(CustDto custDto);
    public int custinsert(CustDto custDto, CustDenyDto custDenyDto);
}
