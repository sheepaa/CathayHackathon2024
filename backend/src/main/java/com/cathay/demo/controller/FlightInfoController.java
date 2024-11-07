package com.cathay.demo.controller;


import com.cathay.demo.entity.FlightInfo;
import com.cathay.demo.service.FlightInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class FlightInfoController {

    @Autowired
    private FlightInfoService flightInfoService;

    @RequestMapping(path="/getFlightInfo", method = RequestMethod.GET)
    public List<FlightInfo> getFlightInfo(
            @RequestParam(name = "destination")String destination,
            @RequestParam(name = "departureTime")String departureTime){
        System.out.println("1111");
        System.out.println(flightInfoService.getFlightInfo(destination, Date.valueOf(departureTime)));
        return flightInfoService.getFlightInfo(destination, Date.valueOf(departureTime));
    }

//    @RequestMapping(path = "/test", method=RequestMethod.GET)
//    public List<FlightInfo> test(){
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(flightInfoService.getFlightInfo("东京成田机场", Date.valueOf("2024-11-16")));
//        return null;
//    }


}
