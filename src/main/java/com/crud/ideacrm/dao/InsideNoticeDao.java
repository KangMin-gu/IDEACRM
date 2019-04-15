package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.InsideNoticeDto;

import java.util.List;
import java.util.Map;

public interface InsideNoticeDao {
    public List<Map<String, Object>> alarmNotRead(int userNo);
    public int notetotalRows(Map<String, Object> noteVal);
    public List<Map<String, Object>> inboxList(Map<String, Object> inBoxVal);
    public void inboxEyeChk(Map<String, Object> noteVal);
    public void inboxTrashChk(Map<String, Object> noteVal);
    public int outTotalRows (Map<String, Object> noteVal);
    public List<Map<String, Object>> outboxList(Map<String, Object> inBoxVal);
    public int trashTotalRows(Map<String, Object> noteTrashVal);
    public List<Map<String, Object>> trashBox(Map<String, Object> noteTrashVal);
    public void noteDeleteChk(Map<String, Object> noteTrashVal);
    public void noteReturnChk(Map<String, Object> noteTrashVal);
    public List<Map<String, Object>> composeData(Map<String, Object> composeVal);
    public int send(InsideNoticeDto insDto);
}
