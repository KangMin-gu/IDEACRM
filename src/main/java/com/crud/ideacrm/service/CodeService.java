package com.crud.ideacrm.service;

import java.util.Map;

public interface CodeService {
    public Map<String,Object> getCommonCode(String moduleName, int siteid);
    public Map<String,Object> getCustomCode(String moduleName, int siteid);
    public void test();
}
