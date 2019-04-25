package com.crud.ideacrm.crud.util;

import javax.servlet.http.*;

public class SessionListner implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        HttpSession session = se.getSession();

        long time = session.getCreationTime();

        long last_time = session.getLastAccessedTime();

        long now_time = System.currentTimeMillis();

        String id = session.getId();

        System.out.println((now_time - last_time) + "ms 만에 세션이 죽음"  + id);

    }
}
