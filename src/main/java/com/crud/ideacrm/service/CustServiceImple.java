package com.crud.ideacrm.service;

import com.crud.ideacrm.dao.CustDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustServiceImple implements CustService{

    @Autowired
    CustDao custDao;

    @Override
    public List<Map<String, Object>> custList(Map<String, Object> searchPrm) {
        return custDao.custList(searchPrm);
    }
}
