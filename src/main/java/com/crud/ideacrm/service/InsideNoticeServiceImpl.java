package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.util.PagingUtil;
import com.crud.ideacrm.dao.InsideNoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsideNoticeServiceImpl implements InsideNoticeService {

    @Autowired
    private InsideNoticeDao insnd;
    @Autowired
    private PagingUtil paging;

    @Override
    public List<Map<String, Object>> alarmNotRead(HttpServletRequest request) {
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        List<Map<String, Object>> alarmNotRead = insnd.alarmNotRead(userNo);
        return alarmNotRead;
    }

    @Override
    public ModelAndView inboxList(HttpServletRequest request) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        String keyword=request.getParameter("keyword");
        String condition=request.getParameter("condition");

        ModelAndView mView = new ModelAndView();
        //한 페이지에 나타낼 갯수 설정
        int PAGE_DISPLAY_COUNT = 5;
        int PAGE_ROW_COUNT = 14;

        Map<String, Object> noteVal = new HashMap<>();
        if(keyword != null && !keyword.equals("")){ //검색어가 전달된 경우
            if(condition.equals("titlecontent")){
                noteVal.put("titlecontent", keyword);
            }else if(condition.equals("title")){//제목 검색
                noteVal.put("title", keyword);
            }else if(condition.equals("sender")){//작성자 검색
                noteVal.put("sender", keyword);
            }

            mView.addObject("condition", condition);
            mView.addObject("keyword", keyword);
        }

        //Mapper 검색 조건 담기
        noteVal.put("siteid", siteId);
        noteVal.put("userno", userNo);

        //토탈로우 디비컨넥션
        int totalRows = insnd.notetotalRows(noteVal);

        //페이징 생성자 호출 후 로직실행
        Map<String, Integer> page = paging.paging(request, totalRows, PAGE_ROW_COUNT, PAGE_DISPLAY_COUNT);
        int startRowNum = page.get("startRowNum");
        int endRowNum = page.get("endRowNum");

        //받은메세지 리스트 추출
        noteVal.put("startRowNum", startRowNum);
        noteVal.put("endRowNum", endRowNum);

        //받은통지 리스트 출력
        List<Map<String, Object>> note = insnd.inboxList(noteVal);

        mView.addObject("page", page); //페이징처리
        mView.addObject("noteList", note); //리스트처리

        return mView;

    }

    @Override
    public void inboxEyeChk(HttpServletRequest request, List<Integer> noticeid) {
        Map<String, Object> noteVal = new HashMap<>();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        for(int i = 0; i<noticeid.size(); i++) {
            noteVal.put("siteid", siteId);
            noteVal.put("userno", userNo);
            noteVal.put("noticeid", noticeid.get(i));
            insnd.inboxEyeChk(noteVal);
            noteVal.clear();
        }
    }

    @Override
    public void inboxTrashChk(HttpServletRequest request, List<Integer> noticeid) {
        Map<String, Object> noteVal = new HashMap<>();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        for(int i = 0; i<noticeid.size(); i++) {
            noteVal.put("siteid", siteId);
            noteVal.put("userno", userNo);
            noteVal.put("noticeid", noticeid.get(i));
            insnd.inboxTrashChk(noteVal);
            noteVal.clear();
        }
    }


}
