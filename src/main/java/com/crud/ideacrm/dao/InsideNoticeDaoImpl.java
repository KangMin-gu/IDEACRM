package com.crud.ideacrm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class InsideNoticeDaoImpl implements InsideNoticeDao {

    @Autowired
    private SqlSession session;

    @Override
    public List<Map<String, Object>> alarmNotRead(int userNo) {
        List<Map<String, Object>> alarmNotRead =session.selectList("insideNotice.alarmNotRead", userNo);
        return alarmNotRead;
    }

    @Override
    public int notetotalRows(Map<String, Object> noteVal) {
        int totalRows = session.selectOne("insideNotice.totalRows", noteVal);
        return totalRows;
    }

    @Override
    public List<Map<String, Object>> inboxList(Map<String, Object> inBoxVal) {
        List<Map<String, Object>> note = session.selectList("insideNotice.inbox", inBoxVal);
        return note;
    }

    @Override
    public void inboxEyeChk(Map<String, Object> noteVal) {
        session.update("insideNotice.inboxEyeChk",noteVal);
    }

    @Override
    public void inboxTrashChk(Map<String, Object> noteVal) {
        session.update("insideNotice.inboxTrashChk",noteVal);
    }
}
