package com.crud.ideacrm.crud.util;

import com.crud.ideacrm.dao.UserDao;
import com.crud.ideacrm.service.InsideNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AlarmHandler extends TextWebSocketHandler {

    @Autowired
    private InsideNoticeService Ins;

    @Autowired
    private UserDao urDao;

    private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
    private static final Logger logger = LoggerFactory.getLogger(AlarmHandler.class);
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String ntCountKey = message.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> maps = mapper.readValue(ntCountKey, new TypeReference<Map<String, Object>>() {});

        int userNo =  Integer.parseInt((String) maps.get("userNo"));
        int siteId = Integer.parseInt((String) maps.get("siteId"));
        Map<String,Object> alarmVal = new HashMap<>();
        alarmVal.put("userno", userNo);
        alarmVal.put("siteid", siteId);

        WebSocketMessage<Map<String, Object>> alarmInfo = new WebSocketMessage<Map<String, Object>>() {

            @Override
            public Map<String, Object> getPayload() {
                Map<String, Object> alarmInfo = urDao.userAram(alarmVal);

                return alarmInfo;
            }


            public int getPayloadLength() {
                return 0;
            }

            @Override
            public boolean isLast() {
                return false;
            }
        };

        String alarmJson = "";
        alarmJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarmInfo);

        for(WebSocketSession s: list) {
            s.sendMessage(new TextMessage(alarmJson));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        list.remove(session);
    }

}
