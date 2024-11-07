package com.cathay.demo.dao;

import com.cathay.demo.entity.FerryTicket;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface FerryTicketMapper {

    List<FerryTicket> selectFerryTicket();
}
