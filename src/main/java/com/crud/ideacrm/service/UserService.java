package com.crud.ideacrm.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<Map<String,Object>> userList(HttpServletRequest request);
}
