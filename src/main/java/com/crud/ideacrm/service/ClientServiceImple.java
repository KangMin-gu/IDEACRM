package com.crud.ideacrm.service;

import com.crud.ideacrm.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImple implements ClientService {
    @Autowired
    ClientDao clientDao;

    @Override
    public List<Map<String, Object>> clientList(Map<String, Object> searchParam) {
        return clientDao.clientList(searchParam);
    }
}
