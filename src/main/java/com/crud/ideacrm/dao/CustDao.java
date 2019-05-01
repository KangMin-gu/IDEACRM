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
    public int custUpdate(CustDto custDto);
    public int custDenyUpdate(CustDenyDto custDenyDto);
    public int custDelete(CustDto custDto);
    public int custDenyDelete(CustDto custDto);
    public List<Map<String,Object>> custMailList(Map<String,Object> searchPrm);
    public List<Map<String,Object>> custSmsList(Map<String,Object> searchPrm);
    public List<Map<String,Object>> custMmsList(Map<String,Object> searchPrm);
    public List<Map<String,Object>> custLmsList(Map<String,Object> searchPrm);
    public List<Map<String,Object>> custKakaoList(Map<String,Object> searchPrm);
}
