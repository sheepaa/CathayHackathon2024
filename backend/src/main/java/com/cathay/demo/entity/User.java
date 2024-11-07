package com.cathay.demo.entity;

import lombok.Data;

@Data
public class User {
    private int memberId;
    private String email;
    private String countryCode;
    private String phone;
    private String tags;
    private String password;
    private String salt;
}
