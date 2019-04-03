package com.crud.ideacrm.service;

import com.crud.ideacrm.dao.CustDao;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustServiceImple implements CustService{

    @Autowired
    CustDao custDao;
    //고객 리스트
    @Override
    public List<Map<String, Object>> custList(Map<String, Object> searchPrm) {
        return custDao.custList(searchPrm);
    }
    //고객 상세
    @Override
    public Map<String, Object> custDetail(CustDto custDto) {
        return custDao.custDetail(custDto);
    }

    //고객 추가
    @Override
    public int custinsert(CustDto custDto, CustDenyDto custDenyDto) {
        custDao.custInsert(custDto);
        int custNo = custDto.getCustno();
        custDenyDto.setCustno(custNo);
        custDao.custDenyInsert(custDenyDto);
        if(custDto.getClino() != 0) {//clino가 존재하면 거래처-관련고객 테이블에 insert
            custDao.mergeCliCust(custDto);
        }
        return custNo;
    }
}
