package com.crud.ideacrm.crud.dao;

import com.crud.ideacrm.crud.dto.UploadDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UploadDaoImpl implements  UploadDao{

    @Autowired
    private SqlSession session;

    @Override
    public void upload(UploadDto uploadDto) {
        session.insert("file.upload", uploadDto);
    }

    @Override
    public List<Map<String,Object>> fileInfo(Map<String, Object> noteInfo) {
        List<Map<String,Object>> fileInfo = session.selectList("file.info", noteInfo);
        return fileInfo;
    }

    @Override
    public UploadDto download(int fileId) {
        return session.selectOne("file.download", fileId);
    }
}
