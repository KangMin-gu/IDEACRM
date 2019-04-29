package com.crud.ideacrm.controller;

import com.crud.ideacrm.dao.UserDao;
import com.crud.ideacrm.dto.UserDto;
import com.crud.ideacrm.service.InsideNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class AlarmController {

    @Autowired
    private InsideNoticeService isns;

    @Autowired
    private UserDao userdao;

    //알람_안읽은편지
    @RequestMapping(value = "/insnotread", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> authAlarmNotRead(HttpServletRequest request){
        List<Map<String, Object>> alarmNotRead = isns.alarmNotRead(request);
        return alarmNotRead;
    }


    //알람_안읽은편지
    @RequestMapping(value = "/noticeread", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> authAlarmNoticeRead(HttpServletRequest request, @RequestBody Map<String, Object> alarmVal){
        Map<String, Object> alarmNoticeRead = userdao.userAram(alarmVal);
        return alarmNoticeRead;
    }

}
