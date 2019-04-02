package com.crud.ideacrm.service;

import com.crud.ideacrm.dto.RactDto;
import com.crud.ideacrm.dto.RewardDto;
import com.crud.ideacrm.dto.ServiceDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ServiceService {

    public List<Map<String,Object>> serviceList(HttpServletRequest request);
    public ModelAndView serviceDetail(HttpServletRequest request, int serviceNo);
    public int serviceInsertUpdate(HttpServletRequest request, ServiceDto serviceDto, RewardDto rewardDto, RactDto ractDto);


}
