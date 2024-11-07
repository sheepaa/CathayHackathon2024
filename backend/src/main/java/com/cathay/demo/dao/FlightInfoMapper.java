package com.cathay.demo.dao;


import com.cathay.demo.entity.FlightInfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface FlightInfoMapper {
    List<FlightInfo> selectFlightInfo(String destination, Date departureTime);
}
