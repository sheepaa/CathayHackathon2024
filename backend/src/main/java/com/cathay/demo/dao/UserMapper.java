package com.cathay.demo.dao;

import com.cathay.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int memberId);
}
