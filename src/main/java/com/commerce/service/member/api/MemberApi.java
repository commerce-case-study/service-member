package com.commerce.service.member.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.service.member.dao.MemberDao;
import com.commerce.service.member.dto.MemberDto;

@RestController
public class MemberApi {

    Logger logger = LoggerFactory.getLogger(MemberApi.class);

    @Autowired
    MemberDao memberDao;
    
    @GetMapping(value = "findByEmailOrUsername/{email}/{username}", produces = "application/json")
    public MemberDto findByEmailOrUsername(@PathVariable("email") String email, @PathVariable("username") String username) {
        return memberDao.findByEmailOrUsername(email, username);
    }

    @GetMapping(value = "findByEmailOrUsernameOrPhone/{email}/{username}/{phone}", produces = "application/json")
    public MemberDto findByEmailOrUsernameOrPhone(@PathVariable("email") String email, @PathVariable("username") String username, @PathVariable("phone") String phone) {
        return memberDao.findByEmailOrUsernameOrPhone(email, username, phone);
    }
    
    @GetMapping(value = "findByUsername/{username}", produces = "application/json")
    public MemberDto findByUsername(@PathVariable("username") String username) {
        return memberDao.findByUsername(username);
    }

    @PostMapping(value = "registerMember", consumes = "application/json")
    public Long registerMember(@RequestBody MemberDto member) {
        if(memberDao.registerMember(member) > 0) {
            return member.getId();
        }
        return -1L;
    }
    
    @PostMapping(value = "updateMember", consumes = "application/json")
    public Long updateMember(@RequestBody MemberDto member) {
    	if(memberDao.updateMember(member) > 0) {
            return member.getId();
        }
        return -1L;
    }
}
