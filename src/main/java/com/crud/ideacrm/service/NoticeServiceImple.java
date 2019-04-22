package com.crud.ideacrm.service;

import com.crud.ideacrm.crud.dao.UploadDao;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.crud.util.Uplaod;
import com.crud.ideacrm.dao.NoticeDao;
import com.crud.ideacrm.dto.NoticeDto;
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
public class NoticeServiceImple implements NoticeService{

    @Autowired
    private ParameterUtil prmUtil;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private UploadDao uploadDao;

    @Autowired
    private Uplaod uplaod;

    @Autowired
    private CodeService codeService;

    private final int USINGMENU = 5;

    @Override
    public List<Map<String, Object>> siteNoticeList(HttpServletRequest request) {
        Map<String,Object> param = prmUtil.searchParam(request);
        List<Map<String, Object>> noticeList = noticeDao.siteNoticeList(param);
        return noticeList;
    }

    @Override
    public ModelAndView siteNoticeDetail(HttpServletRequest request, int noticeId) {
        Map<String, Object> notice = noticeDao.siteNoticeDetail(noticeId);
        ModelAndView mView = new ModelAndView();
        Map<String, Object> noteInfo = new HashMap<>();
        noteInfo.put("filesearchkey",notice.get("FILESEARCHKEY"));
        List<Map<String,Object>> fileInfo = uploadDao.fileInfo(noteInfo);

        mView.addObject("fileInfo",fileInfo);
        mView.addObject("notice", notice);
        return mView;
    }

    @Override
    public int siteNoticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        noticeDto.setSiteid(siteId);
        noticeDto.setReguser(userNo);
        noticeDto.setEdtuser(userNo);

        //파일업로드
        List<MultipartFile> mFile = noticeDto.getFile();
        if(mFile  != null && mFile.size() >= 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            noticeDto.setFilesearchkey(fileSearchKey);
        }

        int noticeId = noticeDao.siteNoticeInsert(noticeDto);
        return noticeId;
    }

    @Override
    public ModelAndView siteNoticeUpdateForm(HttpServletRequest request, int noticeId) {
        Map<String,Object> noticeInfo = noticeDao.siteNoticeDetail(noticeId);
        Map<String,Object> fileVal = new HashMap<>();
        fileVal.put("filesearchkey",noticeInfo.get("FILESEARCHKEY"));
        List<Map<String, Object>> fileInfo =  uploadDao.fileInfo(fileVal);
        ModelAndView mView = new ModelAndView();
        mView.addObject("noticeInfo",noticeInfo);
        mView.addObject("fileInfo",fileInfo);
        return mView;
    }

    @Override
    public int siteNoticeUpdate(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        noticeDto.setEdtuser(userNo);
        noticeDto.setSiteid(siteId);

        //파일업로드
        List<MultipartFile> mFile = noticeDto.getFile();
        if(mFile  != null && mFile.size() >= 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            noticeDto.setFilesearchkey(fileSearchKey);
        }

        int noticeId = noticeDao.siteNoticeUpdate(noticeDto);

        return noticeId;
    }

    @Override
    public void siteNoticeDel(HttpServletRequest request, int noticeId) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setSiteid(siteId);
        noticeDto.setEdtuser(userNo);
        noticeDto.setNtnum(noticeId);

        noticeDao.siteNoticeDel(noticeDto);
    }


    @Override
    public List<Map<String, Object>> noticeList(HttpServletRequest request) {
        Map<String,Object> param = prmUtil.searchParam(request);
        List<Map<String, Object>> noticeList = noticeDao.noticeList(param);
        return noticeList;
    }

    @Override
    public ModelAndView noticeDetail(HttpServletRequest request, int noticeId) {
        Map<String, Object> notice = noticeDao.noticeDetail(noticeId);
        ModelAndView mView = new ModelAndView();
        Map<String, Object> noteInfo = new HashMap<>();
        noteInfo.put("filesearchkey",notice.get("FILESEARCHKEY"));
        List<Map<String,Object>> fileInfo = uploadDao.fileInfo(noteInfo);

        mView.addObject("fileInfo",fileInfo);
        mView.addObject("notice", notice);
        return mView;
    }

    @Override
    public int noticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        noticeDto.setSiteid(siteId);
        noticeDto.setReguser(userNo);
        noticeDto.setEdtuser(userNo);

        //파일업로드
        List<MultipartFile> mFile = noticeDto.getFile();
        if(mFile  != null && mFile.size() >= 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            noticeDto.setFilesearchkey(fileSearchKey);
        }

        int noticeId = noticeDao.noticeInsert(noticeDto);
        return noticeId;
    }

    @Override
    public ModelAndView noticeUpdateForm(HttpServletRequest request, int noticeId) {
        Map<String,Object> noticeInfo = noticeDao.noticeDetail(noticeId);

        Map<String,Object> fileVal = new HashMap<>();
        fileVal.put("filesearchkey",noticeInfo.get("FILESEARCHKEY"));
        List<Map<String, Object>> fileInfo =  uploadDao.fileInfo(fileVal);

        ModelAndView mView = new ModelAndView();
        mView.addObject("noticeInfo",noticeInfo);
        mView.addObject("fileInfo",fileInfo);

        return mView;
    }

    @Override
    public int noticeUpdate(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        noticeDto.setEdtuser(userNo);
        noticeDto.setSiteid(siteId);

        //파일업로드
        List<MultipartFile> mFile = noticeDto.getFile();
        if(mFile  != null && mFile.size() >= 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            noticeDto.setFilesearchkey(fileSearchKey);
        }

        int noticeId = noticeDao.noticeUpdate(noticeDto);

        return noticeId;
    }

    @Override
    public void noticeDel(HttpServletRequest request, int noticeId) {

        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setSiteid(siteId);
        noticeDto.setEdtuser(userNo);
        noticeDto.setNtnum(noticeId);

        noticeDao.noticeDel(noticeDto);
    }

    @Override
    public List<Map<String, Object>> vocNoticeList(HttpServletRequest request) {
        Map<String,Object> param = prmUtil.searchParam(request);
        List<Map<String, Object>> noticeList = noticeDao.vocNoticeList(param);
        return noticeList;
    }

    @Override
    public ModelAndView vocNoticeDetail(HttpServletRequest request, int noticeId) {
        Map<String, Object> notice = noticeDao.vocNoticeDetail(noticeId);
        ModelAndView mView = new ModelAndView();
        Map<String, Object> noteInfo = new HashMap<>();
        noteInfo.put("filesearchkey",notice.get("FILESEARCHKEY"));
        List<Map<String,Object>> fileInfo = uploadDao.fileInfo(noteInfo);

        mView.addObject("fileInfo",fileInfo);
        mView.addObject("notice", notice);
        return mView;
    }

    @Override
    public int vocNoticeInsert(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        noticeDto.setSiteid(siteId);
        noticeDto.setReguser(userNo);
        noticeDto.setEdtuser(userNo);

        //파일업로드
        List<MultipartFile> mFile = noticeDto.getFile();
        if(mFile  != null && mFile.size() >= 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            noticeDto.setFilesearchkey(fileSearchKey);
        }

        int noticeId = noticeDao.vocNoticeInsert(noticeDto);
        return noticeId;
    }

    @Override
    public ModelAndView vocNoticeUpdateForm(HttpServletRequest request, int noticeId) {
        Map<String,Object> noticeInfo = noticeDao.vocNoticeDetail(noticeId);

        Map<String,Object> fileVal = new HashMap<>();
        fileVal.put("filesearchkey",noticeInfo.get("FILESEARCHKEY"));
        List<Map<String, Object>> fileInfo =  uploadDao.fileInfo(fileVal);

        ModelAndView mView = new ModelAndView();
        mView.addObject("noticeInfo",noticeInfo);
        mView.addObject("fileInfo",fileInfo);

        return mView;
    }

    @Override
    public int vocNoticeUpdate(HttpServletResponse response, HttpServletRequest request, NoticeDto noticeDto) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        noticeDto.setEdtuser(userNo);
        noticeDto.setSiteid(siteId);

        //파일업로드
        List<MultipartFile> mFile = noticeDto.getFile();
        if(mFile  != null && mFile.size() >= 0 && mFile.isEmpty() == false){
            String fileSearchKey = uplaod.multiUpload(response, request, mFile);
            noticeDto.setFilesearchkey(fileSearchKey);
        }

        int noticeId = noticeDao.vocNoticeUpdate(noticeDto);

        return noticeId;
    }

    @Override
    public void vocNoticeDel(HttpServletRequest request, int noticeId) {
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());

        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setSiteid(siteId);
        noticeDto.setEdtuser(userNo);
        noticeDto.setNtnum(noticeId);

        noticeDao.vocNoticeDel(noticeDto);
    }
}
