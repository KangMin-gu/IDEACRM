package com.crud.ideacrm.crud.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.ideacrm.crud.dto.UploadDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component("fileDownView")
public class DownLoadView extends AbstractView{


    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        UploadDto fileInfo = (UploadDto)model.get("fileInfo");
        String orgFileName = fileInfo.getOrgfilename();
        String saveFileName = fileInfo.getSavefilename();
        long fileSize=fileInfo.getFilesize();
        String path = fileInfo.getPath();

        FileInputStream fis = new FileInputStream(path);

        String encodedName = null;

        if(request.getHeader("User-Agent").contains("Firefox")){
            //벤더사가 파이어 폭스인경우
            encodedName=new String
                    (orgFileName.getBytes("utf-8"),"ISO-8859-1");
        }else{ //그외 다른 벤더사
            encodedName=URLEncoder.encode(orgFileName, "utf-8");
            //파일명에 공백이있는 경우 처리
            encodedName=encodedName.replaceAll("\\+"," ");
        }

        response.setHeader("Content-Disposition","attachment;filename="+encodedName);
        response.setHeader("Content-Transfer-Encoding", "binary");

        response.setContentLengthLong(fileSize);

        BufferedOutputStream bos=
                new BufferedOutputStream(response.getOutputStream());
        //한번에 최대 1M byte 씩 읽어올수 있는 버퍼
        byte[] buffer=new byte[1024*1000];
        int readedByte=0;
        //반복문 돌면서 출력해주기
        while(true){
            //byte[] 객체를 이용해서 파일에서 byte 알갱이 읽어오기
            readedByte = fis.read(buffer);
            if(readedByte == -1)break; //더이상 읽을 데이터가 없다면 반복문 빠져 나오기
            //읽은 만큼 출력하기
            bos.write(buffer, 0, readedByte);
            bos.flush(); //출력
        }
        //스트림 닫아주기
        bos.close();
        fis.close();

    }
}
