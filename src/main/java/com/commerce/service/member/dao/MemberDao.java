package com.commerce.service.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.commerce.service.member.dto.MemberDto;

@Mapper
public interface MemberDao {

    MemberDto findByEmail(String email);
    
    MemberDto findByUsername(String username);
    
    MemberDto findByEmailOrUsername(String email, String username);
    
    MemberDto findByEmailOrUsernameOrPhone(String email, String username, String phone);
    
    Long registerMember(MemberDto member);
    
    Long updateMember(MemberDto member);
}
