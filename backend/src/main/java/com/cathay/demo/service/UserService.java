package com.cathay.demo.service;

import com.cathay.demo.dao.UserMapper;
import com.cathay.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User findUserByMemberId(int memberId){
        return userMapper.selectById(memberId);
    }
}
