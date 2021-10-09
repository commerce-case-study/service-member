package com.metranet.finbox.service.member.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metranet.finbox.service.member.dao.MemberDao;
import com.metranet.finbox.service.member.dto.MemberDto;

@RestController
public class MemberServiceApi {

    Logger logger = LoggerFactory.getLogger(MemberServiceApi.class);

    @Autowired
    MemberDao memberDao;
    
    @GetMapping(value = "findByEmailOrUsername/{email}/{username}", produces = "application/json")
    public MemberDto findByEmailOrUsername(String email, String username) {
        return memberDao.findByEmailOrUsername(email, username);
    }

    @GetMapping(value = "findByEmailOrUsernameOrPhone/{email}/{username}/{phone}", produces = "application/json")
    public MemberDto findByEmailOrUsernameOrPhone(String email, String username, String phone) {
        return memberDao.findByEmailOrUsernameOrPhone(email, username, phone);
    }
    
    @GetMapping(value = "findByUsername/{username}", produces = "application/json")
    public MemberDto findByUsername(String username) {
        return memberDao.findByUsername(username);
    }

    @PostMapping(value = "registerMember", consumes = "application/json")
    public Long registerMember(MemberDto member) {
        if(memberDao.registerMember(member) > 0) {
            return member.getId();
        }
        return -1L;
    }
    
    @PostMapping(value = "updateMember", consumes = "application/json")
    public Long updateMember(MemberDto member) {
    	if(memberDao.updateMember(member) > 0) {
            return member.getId();
        }
        return -1L;
    }
}
