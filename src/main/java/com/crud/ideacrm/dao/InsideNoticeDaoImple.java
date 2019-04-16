package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.InsideNoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class InsideNoticeDaoImple implements InsideNoticeDao {

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

    @Override
    public int outTotalRows(Map<String, Object> noteVal) {
        int totalRows = session.selectOne("insideNotice.outTotalRows", noteVal);
        return totalRows;
    }

    @Override
    public List<Map<String, Object>> outboxList(Map<String, Object> noteVal) {
        List<Map<String, Object>> note = session.selectList("insideNotice.outbox", noteVal);
        return note;
    }

    @Override
    public int trashTotalRows(Map<String, Object> noteTrashVal) {
        int totalRows = session.selectOne("insideNotice.trashTotalRows", noteTrashVal);
        return totalRows;
    }

    @Override
    public List<Map<String, Object>> trashBox(Map<String, Object> noteTrashVal) {
        List<Map<String, Object>> note = session.selectList("insideNotice.trashbox", noteTrashVal);
        return note;
    }

    @Override
    public void noteDeleteChk(Map<String, Object> noteTrashVal) {
        session.update("insideNotice.noteDeleteChk",noteTrashVal);
    }

    @Override
    public void noteReturnChk(Map<String, Object> noteTrashVal) {
        session.update("insideNotice.noteReturnChk",noteTrashVal);
    }

    @Override
    public List<Map<String, Object>> composeData(Map<String, Object> composeVal) {
        List<Map<String, Object>> composeData = session.selectList("insideNotice.composeUserData", composeVal);
        return composeData;
    }

    @Override
    public int send(InsideNoticeDto insDto) {
        session.insert("insideNotice.send", insDto);
        int noticeId = insDto.getNoticeid();
        return noticeId;
    }

    @Override
    public void to(InsideNoticeDto insDto) {
        session.insert("insideNotice.to",insDto);
    }

    @Override
    public Map<String, Object> boxDetail(int noticeId) {
        Map<String, Object> noteInfo = session.selectOne("insideNotice.noteDetail", noticeId);
        return noteInfo;
    }

    @Override
    public List<Map<String, Object>> toList (int noticeId) {
        List<Map<String, Object>> toList = session.selectList("insideNotice.toList", noticeId);
        return toList;
    }
}
