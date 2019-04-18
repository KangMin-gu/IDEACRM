package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UserDto;

import java.util.Map;

public interface MemberDao {
    public Map<String, Object> userInfo(int userId);
    public void memeberChangePwd(UserDto userDto);
}
