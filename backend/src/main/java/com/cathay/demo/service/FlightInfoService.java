package com.cathay.demo.service;


import com.cathay.demo.dao.FlightInfoMapper;
import com.cathay.demo.entity.FlightInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FlightInfoService {

    @Autowired
    private FlightInfoMapper flightInfoMapper;

    public List<FlightInfo> getFlightInfo( String destination, Date departureTime){
        System.out.println("depature time is " + departureTime);
        return flightInfoMapper.selectFlightInfo(destination, departureTime);
    }
}
