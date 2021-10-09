package com.commerce.service.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.commerce.service.member.dto.ClientDto;

@Mapper
public interface ClientDao {

    ClientDto findByClientId(String clientId);
}
