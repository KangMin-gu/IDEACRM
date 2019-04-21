package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.dao.UploadDao;
import com.crud.ideacrm.crud.util.PagingUtil;
import com.crud.ideacrm.crud.util.Uplaod;
import com.crud.ideacrm.dao.InsideNoticeDao;
import com.crud.ideacrm.dto.InsideNoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsideNoticeServiceImple implements InsideNoticeService {

    @Autowired
    private InsideNoticeDao insnd;
    @Autowired
    private PagingUtil paging;
    @Autowired
    private Uplaod uplaod;
    @Autowired
    private UploadDao uploadDao;

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

    @Override
    public ModelAndView outboxList(HttpServletRequest request) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        String keyword=request.getParameter("keyword");
        String condition=request.getParameter("condition");

        ModelAndView mView = new ModelAndView();
        //한 페이지에 나타낼 갯수 설정
        int PAGE_DISPLAY_COUNT = 5;
        int PAGE_ROW_COUNT = 14;


        Map<String, Object> noteVal = new HashMap<>();

        if(keyword != null && !keyword.equals("")){
            if(condition.equals("titlecontent")){
                noteVal.put("titlecontent", keyword);
            }else if(condition.equals("title")){
                noteVal.put("title", keyword);
            }else if(condition.equals("recipient")){
                noteVal.put("recipient", keyword);
            }

            mView.addObject("condition", condition);
            mView.addObject("keyword", keyword);
        }

        //Mapper 검색 조건 담기
        noteVal.put("siteid", siteId);
        noteVal.put("userno", userNo);

        //토탈로우 디비컨넥션
        int totalRows = insnd.outTotalRows(noteVal);

        //페이징 생성자 호출 후 로직실행
        Map<String, Integer> page = paging.paging(request, totalRows, PAGE_ROW_COUNT, PAGE_DISPLAY_COUNT);
        int startRowNum = page.get("startRowNum");
        int endRowNum = page.get("endRowNum");

        //받은메세지 리스트 추출
        noteVal.put("startRowNum", startRowNum);
        noteVal.put("endRowNum", endRowNum);

        //받은통지 리스트 출력
        List<Map<String, Object>> note = insnd.outboxList(noteVal);

        mView.addObject("page", page); //페이징처리
        mView.addObject("noteList", note); //리스트처리

        return mView;

    }

    @Override
    public ModelAndView trashbox(HttpServletRequest request) {
        //세션에서 사용자정보를 가져온다.
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        //검색과 관련된 파라미터를 읽어와 본다.
        String keyword=request.getParameter("keyword");
        String condition=request.getParameter("condition");

        //한 페이지에 나타낼 갯수 설정
        int PAGE_DISPLAY_COUNT = 5;
        int PAGE_ROW_COUNT = 14;

        ModelAndView mView = new ModelAndView();
        Map<String, Object> noteTrashVal = new HashMap<>();

        if(keyword != null && !keyword.equals("")){ //검색어가 전달된 경우
            if(condition.equals("titlecontent")){
                noteTrashVal.put("titlecontent", keyword);
            }else if(condition.equals("title")){//제목 검색
                noteTrashVal.put("title", keyword);
            }else if(condition.equals("sender")){//작성자 검색
                noteTrashVal.put("sender", keyword);
            }

            mView.addObject("condition", condition);
            mView.addObject("keyword", keyword);
        }

        //Mapper 검색 조건 담기
        noteTrashVal.put("siteid", siteId);
        noteTrashVal.put("userno", userNo);

        //토탈로우 디비컨넥션
        int totalRows = insnd.trashTotalRows(noteTrashVal);

        //페이징 생성자 호출 후 로직실행
        Map<String, Integer> page = paging.paging(request, totalRows, PAGE_ROW_COUNT, PAGE_DISPLAY_COUNT);
        int startRowNum = page.get("startRowNum");
        int endRowNum = page.get("endRowNum");

        //받은메세지 리스트 추출
        noteTrashVal.put("startRowNum", startRowNum);
        noteTrashVal.put("endRowNum", endRowNum);

        //보낸통지 리스트 출력
        List<Map<String, Object>> note = insnd.trashBox(noteTrashVal);


        mView.addObject("page", page); //페이징처리
        mView.addObject("noteList", note); //리스트처리

        return mView;
    }

    @Override
    public void noteDeleteChk(HttpServletRequest request, List<Integer> noticeid) {
        Map<String, Object> noteVal = new HashMap<>();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        for(int i = 0; i<noticeid.size(); i++) {
            noteVal.put("siteid", siteId);
            noteVal.put("userno", userNo);
            noteVal.put("noticeid", noticeid.get(i));
            insnd.noteDeleteChk(noteVal);
            noteVal.clear();
        }
    }

    @Override
    public void noteReturnChk(HttpServletRequest request, List<Integer> noticeid) {
        Map<String, Object> noteVal = new HashMap<>();
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        for(int i = 0; i<noticeid.size(); i++) {
            noteVal.put("siteid", siteId);
            noteVal.put("userno", userNo);
            noteVal.put("noticeid", noticeid.get(i));
            insnd.noteReturnChk(noteVal);
            noteVal.clear();
        }
    }

    @Override
    public ModelAndView composeData(HttpServletRequest request) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        String reno = request.getParameter("reno");
        String reply = request.getParameter("reply");

        ModelAndView mView = new ModelAndView();
        if(reply != null && reply != ""){
            int replyNo = Integer.parseInt(request.getParameter("reply"));
            Map<String, Object> noteInfo = insnd.boxDetail(replyNo);
            mView.addObject("noteInfo",noteInfo);
        }

        if(reno != null && reno != ""){
            mView.addObject("reno",reno);
        }

        Map<String, Object> composeVal = new HashMap<>();
        composeVal.put("userno", userNo);
        composeVal.put("siteid", siteId);

        List<Map<String, Object>> composeData = insnd.composeData(composeVal);
        mView.addObject("companyUserData", composeData);
        mView.addObject("reply", reply);

        return mView;
    }

    @Override
    public int send(HttpServletResponse response, HttpServletRequest request, InsideNoticeDto insDto) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        insDto.setSiteid(siteId);
        insDto.setFromuserno(userNo);

        //파일업로드
        List<MultipartFile> mFile = insDto.getFile();
        if(mFile  != null && mFile.size() > 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            insDto.setFilesearchkey(fileSearchKey);
        }

        //통지등록
        int noticeId =  insnd.send(insDto);
        insDto.setNoticeid(noticeId);

        String toUserList[] = request.getParameterValues("touser");
        for(String a : toUserList) {
            int toUserNo = Integer.parseInt(a);
            insDto.setTouserno(toUserNo);
            //수신인 통지발송
            insnd.to(insDto);
        }


        //메일발송로직구현예정


        return noticeId;
    }

    @Override
    public ModelAndView boxDetail(HttpServletRequest request, int noticeId) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());


        ModelAndView mView = new ModelAndView();
        Map<String, Object> noteInfo = insnd.boxDetail(noticeId);
        Map<String, Object> fileVal = new HashMap<>();
        fileVal.put("filesearchkey", noteInfo.get("FILESEARCHKEY"));
        List<Map<String,Object>> fileInfo = uploadDao.fileInfo(fileVal);

        Map<String, Object> noteVal = new HashMap<>();
        noteVal.put("siteid", siteId);
        noteVal.put("userno", userNo);
        noteVal.put("noticeid", noticeId);
        insnd.inboxEyeChk(noteVal);
        List<Map<String,Object>> toList = insnd.toList(noticeId);

        mView.addObject("fileInfo",fileInfo);
        mView.addObject("toList",toList);
        mView.addObject("noteInfo",noteInfo);
        mView.addObject("location","inbox");
        return mView;
    }

    @Override
    public ModelAndView outBoxDetail(HttpServletRequest request, int noticeId) {
        ModelAndView mView = new ModelAndView();
        Map<String, Object> noteInfo = insnd.boxDetail(noticeId);
        List<Map<String,Object>> fileInfo = uploadDao.fileInfo(noteInfo);
        List<Map<String,Object>> toList = insnd.toList(noticeId);

        mView.addObject("toList",toList);
        mView.addObject("fileInfo",fileInfo);
        mView.addObject("noteInfo",noteInfo);
        mView.addObject("location","outbox");
        return mView;
    }

    @Override
    public void trashIn(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int noticeId = Integer.parseInt(request.getParameter("noticeid"));
        Map<String, Object> noteVal = new HashMap<>();
        noteVal.put("siteid", siteId);
        noteVal.put("userno", userNo);
        noteVal.put("noticeid", noticeId);
        insnd.inboxTrashChk(noteVal);
    }

    @Override
    public void del(HttpServletRequest request) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        int noticeId = Integer.parseInt(request.getParameter("noticeid"));
        Map<String, Object> noteVal = new HashMap<>();
        noteVal.put("siteid", siteId);
        noteVal.put("userno", userNo);
        noteVal.put("noticeid", noticeId);
        insnd.noteDeleteChk(noteVal);
    }


}
