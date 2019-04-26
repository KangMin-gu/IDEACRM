package com.crud.ideacrm.dao;

import com.crud.ideacrm.dto.UserCtiDto;
import com.crud.ideacrm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<Map<String,Object>> userList(Map<String,Object> param);
    public Map<String, Object> userAram(int userNo);

    public String userInsert(UserDto userDto);
    public void userCtiInsert(UserCtiDto userCtiDto);

    public Map<String,Object> userDetail(UserDto userDto);
    public Map<String,Object> userCtiDetail(UserCtiDto userCtiDto);

    public void userUpdate(UserDto userDto);

    public void userDelete(UserDto userDto);

    public List<Map<String,Object>> userAsOwner(int siteId);
    public void userCtiUpdate(UserCtiDto userCtiDto);

}
