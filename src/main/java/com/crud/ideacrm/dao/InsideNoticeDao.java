package com.crud.ideacrm.dao;

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
}
