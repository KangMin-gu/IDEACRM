package com.crud.ideacrm.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ServiceService {

    public List<Map<String,Object>> serviceList(HttpServletRequest request);

}
