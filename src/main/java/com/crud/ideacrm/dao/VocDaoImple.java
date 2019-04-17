package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.BlackCustDto;
import com.crud.ideacrm.dto.CustDenyDto;
import com.crud.ideacrm.dto.CustDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VocDaoImple implements VocDao {

    @Autowired
    private SqlSession session;

    //voc 고객 업데이트
    @Override
    public int vocCustUpdate(CustDto custDto) {
        return session.update("vocCustUpdate",custDto);
    }

    //voc 고객 수신거부 업데이트
    @Override
    public int vocCustDenyUpdate(CustDenyDto custDenyDto) {
        return session.update("vocCustDenyUpdate",custDenyDto);
    }

    @Override
    public int vocBlackCustInsert(BlackCustDto blackCustDto) {
        return session.insert("vocBlackCustInsert",blackCustDto);
    }

    @Override
    public int vocBlackCustDelete(BlackCustDto blackCustDto) {
        return session.update("vocBlackCustDelete",blackCustDto);
    }

}
