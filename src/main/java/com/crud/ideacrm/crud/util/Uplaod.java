package com.crud.ideacrm.crud.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface Uplaod {
    public String multiUpload(HttpServletResponse response, HttpServletRequest request, List<MultipartFile> multiFile);
}
