package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.FormatDto;

import java.util.List;
import java.util.Map;

public interface FormatDao {

    public List<Map<String,Object>> formatList(Map<String,Object> param);

    public String formatInsert(FormatDto formatDto);
    public Map<String,Object> formatDetail(FormatDto formatDto);
    public void formatUpdate(FormatDto formatDto);
    public void formatDelete(FormatDto formatDto);
}
