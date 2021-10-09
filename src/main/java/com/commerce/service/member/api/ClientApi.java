package com.commerce.service.member.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.service.member.dao.ClientDao;
import com.commerce.service.member.dto.ClientDto;

@RestController
public class ClientApi {

    Logger logger = LoggerFactory.getLogger(ClientApi.class);
    
    @Autowired
    ClientDao clientDao;
    
    @GetMapping(value = "findByClientId/{clientId}", produces = "application/json")
    public ClientDto findByClientId(String clientId) {
        return clientDao.findByClientId(clientId);
    }

}
