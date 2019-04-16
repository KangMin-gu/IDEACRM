package com.crud.ideacrm.crud.dao;

import com.crud.ideacrm.crud.dto.UploadDto;

import java.util.List;
import java.util.Map;

public interface UploadDao {
        public void upload(UploadDto uploadDto);
        public List<Map<String,Object>> fileInfo(Map<String, Object> noteInfo);
        public UploadDto download(int fileId);
}
