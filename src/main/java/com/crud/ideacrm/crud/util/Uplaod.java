package com.crud.ideacrm.crud.util;

import com.crud.ideacrm.crud.dto.UploadDto;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface Uplaod {
    public String multiUpload(HttpServletResponse response, HttpServletRequest request, List<MultipartFile> multiFile);
    public ModelAndView download(int fileId);
}
