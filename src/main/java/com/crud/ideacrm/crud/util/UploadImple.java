package com.crud.ideacrm.crud.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.crud.ideacrm.crud.dao.UploadDao;
import com.crud.ideacrm.crud.dto.UploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
public class UploadImple implements Uplaod {

        @Autowired
        private UploadDao uploadDao;

        //crud.properties
        @Value( "#{props['crud.fileupload.whitelist']}")
        private String whiteList;
        @Value("#{props['crud.singleupload.whitelist']}")
        private String singWhiteList;
        @Value( "#{props['crud.campaign.path']}")
        private String campaign;
        @Value( "#{props['crud.service.path']}")
        private String service;
        @Value( "#{props['crud.notice.path']}")
        private String notice;
        @Value( "#{props['crud.allnotice.path']}")
        private String allnotice;
        @Value( "#{props['crud.vocnotice.path']}")
        private String vocnotice;
        @Value( "#{props['crud.insidenotice.path']}")
        private String insidenotice;
        @Value( "#{props['crud.logo.path']}")
        private String logo;

        @Value( "#{props['crud.campaign.url']}")
        private String campaignUrl;
        @Value( "#{props['crud.service.url']}")
        private String serviceUrl;
        @Value( "#{props['crud.service.url2']}")
        private String serviceUrl2;
        @Value( "#{props['crud.notice.url']}")
        private String noticeUrl;
        @Value( "#{props['crud.notice.url2']}")
        private String noticeUrl2;
        @Value( "#{props['crud.allnotice.url']}")
        private String allnoticeUrl;
        @Value( "#{props['crud.allnotice.url2']}")
        private String allnoticeUrl2;
        @Value( "#{props['crud.vocnotice.url']}")
        private String vocnoticeUrl;
        @Value( "#{props['crud.vocnotice.url2']}")
        private String vocnoticeUrl2;
        @Value( "#{props['crud.insidenotice.url']}")
        private String insidenoticeUrl;
        @Value( "#{props['crud.logo.url']}")
        private String logoUrl;
        @Value( "#{props['crud.logo.url2']}")
        private String logoUrl2;


        @Override
        public String multiUpload(HttpServletResponse response, HttpServletRequest request, List<MultipartFile> multiFile) {

            UploadUtil uploadutil = new UploadUtil();
            String fileSearchKey = uploadutil.fileSearchKey(request);
            int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
            int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
            String url = request.getRequestURI();
            String referer = request.getHeader("Referer");
            Calendar calendar = Calendar.getInstance();
            String years = String.valueOf(calendar.get(Calendar.YEAR));
            String months = String.valueOf(calendar.get(Calendar.MONTH) + 1);
            StringBuffer buf = new StringBuffer();
            UploadDto fileInfo = new UploadDto();
            String realPath = null;

            List<MultipartFile> mFile = multiFile;

            for(int i=0; i<mFile.size(); i++) {

                boolean whiteListFlag = false;
                boolean sizeFlag = false;
                //파일이름 가져오기
                String orgFileName = mFile.get(i).getOriginalFilename();
                //확장자검사
                String[] arrWhiteList = whiteList.split(",");
                String extention = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
                for (String chker : arrWhiteList) {
                    //확장자를 비교해서 있으면 true로 떨굼
                    if (chker.equals(extention)) {
                        whiteListFlag = true;
                    }
                }

                if (!whiteListFlag) {

                    buf.append("<script>alert('허용하지 않는 확장자 입니다.');");
                    buf.append("window.location.replace('");
                    buf.append(referer);
                    buf.append("');</script>");
                    response.setContentType("text/html; charset=UTF-8");
                    PrintWriter out;
                    try {
                        out = response.getWriter();
                        out.println(buf);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                long fileSize = mFile.get(i).getSize();
                sizeFlag = uploadutil.whiteSizeFlag(fileSize);

                if (!sizeFlag) {

                    buf.append("<script>alert('파일용량이 제한용량보다 큽니다.');");
                    buf.append("window.location.replace('");
                    buf.append(referer);
                    buf.append("');</script>");
                    response.setContentType("text/html; charset=UTF-8");
                    PrintWriter out;
                    try {
                        out = response.getWriter();
                        out.println(buf);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                String vocNoticeTarget = "/voc/notice/modified";
                String serviceTarget = "/service/modified";
                String allnoticeTarget = "/notice/modified";
                String noticeTarget = "/company/notice/modified";

                //파일 유입별 경로설정
                if (url.equals(insidenoticeUrl)) {
                    realPath = request.getSession().getServletContext().getRealPath(insidenotice + years + "/" + months + "/" + siteId);
                } else if (url.equals(noticeUrl)) {
                    realPath = request.getSession().getServletContext().getRealPath(notice + years + "/" + months + "/" + siteId);
                } else if (url.contains(noticeTarget)) {
                    realPath = request.getSession().getServletContext().getRealPath(notice + years + "/" + months + "/" + siteId);
                } else if (url.equals(serviceUrl)) {
                    realPath = request.getSession().getServletContext().getRealPath(service + years + "/" + months + "/" + siteId);
                } else if (url.contains(serviceTarget)) {
                    realPath = request.getSession().getServletContext().getRealPath(service + years + "/" + months + "/" + siteId);
                } else if (url.equals(campaignUrl)) {
                    realPath = request.getSession().getServletContext().getRealPath(campaign + years + "/" + months + "/" + siteId);
                } else if (url.equals(allnoticeUrl)) {
                    realPath = request.getSession().getServletContext().getRealPath(allnotice + years + "/" + months + "/" + siteId);
                } else if(url.contains(allnoticeTarget)){
                    realPath = request.getSession().getServletContext().getRealPath(allnotice + years + "/" + months + "/" + siteId);
                }else if(url.equals(vocnoticeUrl)){
                    realPath = request.getSession().getServletContext().getRealPath(vocnotice + years+"/"+months+"/"+siteId);
                }else if(url.contains(vocNoticeTarget)){
                    realPath = request.getSession().getServletContext().getRealPath(vocnotice + years+"/"+months+"/"+siteId);
                }

                String filePath = realPath+File.separator;
                String saveFileName = fileSearchKey+"_"+userNo+"_"+orgFileName;
                String path = filePath + saveFileName;

                File file=new File(filePath);
                if(!file.exists()){
                    file.mkdirs();
                }
                try{
                    mFile.get(i).transferTo(new File(filePath+saveFileName));
                }catch(Exception e){
                    e.printStackTrace();
                }

                fileInfo.setFilesize(fileSize);
                fileInfo.setSavefilename(saveFileName);
                fileInfo.setOrgfilename(orgFileName);
                fileInfo.setPath(path);
                fileInfo.setUserno(userNo);
                fileInfo.setSiteid(siteId);
                fileInfo.setFilesearchkey(fileSearchKey);

                uploadDao.upload(fileInfo);

            }//for

            return fileSearchKey;
        }


    //로고전용
    @Override
    public UploadDto singleUpload(HttpServletResponse response, HttpServletRequest request, MultipartFile singleFile) {
        UploadUtil uploadutil = new UploadUtil();
        String fileSearchKey = uploadutil.fileSearchKey(request);
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        String url = request.getRequestURI();
        String referer = request.getHeader("Referer");
        Calendar calendar = Calendar.getInstance();
        String years = String.valueOf(calendar.get(Calendar.YEAR));
        String months = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        StringBuffer buf = new StringBuffer();
        UploadDto fileInfo = new UploadDto();
        String realPath = null;

        MultipartFile sFile = singleFile;



        boolean whiteListFlag = false;
        boolean sizeFlag = false;
        //파일이름 가져오기
        String orgFileName = sFile.getOriginalFilename();
        //확장자검사
        String[] arrWhiteList = singWhiteList.split(",");
        String extention = orgFileName.substring(orgFileName.lastIndexOf(".")+1,orgFileName.length());
        for(String chker : arrWhiteList) {
            //확장자를 비교해서 있으면 true로 떨굼
            if (chker.equals(extention)) {
                whiteListFlag = true;
            }
        }


            if(!whiteListFlag){

                buf.append("<script>alert('허용하지 않는 확장자 입니다.');");
                buf.append("window.location.replace('");
                buf.append(referer);
                buf.append("');</script>");
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out;
                try {
                    out = response.getWriter();
                    out.println(buf);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            long fileSize = sFile.getSize();
            sizeFlag = uploadutil.whiteSizeFlag(fileSize);

            if(!sizeFlag){

                buf.append("<script>alert('파일용량이 제한용량보다 큽니다.');");
                buf.append("window.location.replace('");
                buf.append(referer);
                buf.append("');</script>");
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out;
                try {
                    out = response.getWriter();
                    out.println(buf);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            String target ="/common/site/modified";

                //파일 유입별 경로설정
            if(url.equals(logoUrl)) {
                realPath = request.getSession().getServletContext().getRealPath(logo+years+"/"+months+"/"+siteId);
            }else if(url.contains(target)){
                realPath = request.getSession().getServletContext().getRealPath(logo+years+"/"+months+"/"+siteId);
            }

            String filePath = realPath+File.separator;
            String saveFileName = fileSearchKey+"_"+userNo+"_"+orgFileName;
            String path = filePath + saveFileName;
            String imgPath = logo+years+"/"+months+"/"+siteId+"/"+saveFileName;

            File file=new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            try{
                sFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }

            fileInfo.setFilesize(fileSize);
            fileInfo.setSavefilename(saveFileName);
            fileInfo.setOrgfilename(orgFileName);
            fileInfo.setPath(path);
            fileInfo.setUserno(userNo);
            fileInfo.setSiteid(siteId);
            fileInfo.setFilesearchkey(fileSearchKey);
            fileInfo.setImgpath(imgPath);

            uploadDao.upload(fileInfo);


        return fileInfo;
    }

    @Override
    public ModelAndView download(int fileId) {
        UploadDto uploadDto = uploadDao.download(fileId);
        ModelAndView mView = new ModelAndView();
        mView.addObject("uploadDto", uploadDto);
        return mView;
    }

}

