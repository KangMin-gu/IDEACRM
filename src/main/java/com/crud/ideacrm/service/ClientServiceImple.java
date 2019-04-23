package com.crud.ideacrm.service;

import com.crud.ideacrm.controller.MainController;
import com.crud.ideacrm.dao.ClientDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImple implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Map<String, Object>> clientList(Map<String, Object> searchParam) {
        return clientDao.clientList(searchParam);
    }
}
