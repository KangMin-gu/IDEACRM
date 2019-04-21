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
}
