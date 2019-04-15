package com.crud.ideacrm.crud.dao;

import com.crud.ideacrm.crud.dto.UploadDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDaoImpl implements  UploadDao{

    @Autowired
    private SqlSession session;

    @Override
    public void upload(UploadDto uploadDto) {
        session.insert("file.upload", uploadDto);
    }
}
