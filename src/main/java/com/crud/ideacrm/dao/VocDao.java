package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

public interface VocDao {
    public int vocCustUpdate(CustDto custDto);
    public int vocCustDenyUpdate(CustDenyDto custDenyDto);
}
