package com.commerce.service.member.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="t_mem_member_address")
public class MemberAddress {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "member_id", nullable = false)
    private Long memberId;
    
    private String province;
    
    private String city;
    
    private String district;
    
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "address_line")
    private String addressLine;
    
    private String notes;
}
