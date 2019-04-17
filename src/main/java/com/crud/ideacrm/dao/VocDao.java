package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.BlackCustDto;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;

public interface VocDao {
    public int vocCustUpdate(CustDto custDto);
    public int vocCustDenyUpdate(CustDenyDto custDenyDto);
    public int vocBlackCustInsert(BlackCustDto blackCustDto);
    public int vocBlackCustDelete(BlackCustDto blackCustDto);
}
