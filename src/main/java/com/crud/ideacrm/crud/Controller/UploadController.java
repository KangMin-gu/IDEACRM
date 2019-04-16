package com.crud.ideacrm.crud.Controller;

import com.crud.ideacrm.crud.dto.UploadDto;
import com.crud.ideacrm.crud.util.Uplaod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadController {

    @Autowired
    private Uplaod uplaod;

    //첨부파일 다운로드
    @RequestMapping(value="/download/{fileId}", method= RequestMethod.GET)
    public ModelAndView download(HttpServletRequest request, @PathVariable int fileId) {
        ModelAndView mView = uplaod.download(fileId);
        mView.setViewName("fileDownView");
        return mView;
    }
}
