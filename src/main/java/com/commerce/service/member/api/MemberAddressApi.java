package com.commerce.service.member.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.service.member.dao.MemberAddressDao;
import com.commerce.service.member.dto.MemberAddressDto;

@RestController
public class MemberAddressApi {

    Logger logger = LoggerFactory.getLogger(MemberAddressApi.class);

    @Autowired
    MemberAddressDao memberAddressDao;
    
    @GetMapping(value = "findByMemberId/{memberId}", produces = "application/json")
    public List<MemberAddressDto> findByEmailOrUsername(@PathVariable("memberId") Long memberId) {
        return memberAddressDao.findByMemberId(memberId);
    }
    
    @PostMapping(value = "addMemberAddress", consumes = "application/json")
    public Long addMemberAddress(@RequestBody MemberAddressDto memberAddress) {
        if(memberAddressDao.addMemberAddress(memberAddress) > 0) {
            return memberAddress.getId();
        }
        return -1L;
    }
    
    @PostMapping(value = "updateMemberAddress", consumes = "application/json")
    public Long updateMemberAddress(@RequestBody MemberAddressDto memberAddress) {
        if(memberAddressDao.updateMemberAddress(memberAddress) > 0) {
            return memberAddress.getId();
        }
        return -1L;
    }
}
