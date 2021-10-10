package com.commerce.service.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.commerce.service.member.dto.MemberAddressDto;

@Mapper
public interface MemberAddressDao {

    Long addMemberAddress(MemberAddressDto memberAddress);
    
    Long updateMemberAddress(MemberAddressDto memberAddress);
    
    List<MemberAddressDto> findByMemberId(Long memberId);
    
    MemberAddressDto findByMemberAddressId(Long id);
}
