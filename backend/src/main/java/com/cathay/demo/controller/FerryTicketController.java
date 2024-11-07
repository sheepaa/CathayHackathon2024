package com.cathay.demo.controller;

import com.cathay.demo.entity.FerryTicket;
import com.cathay.demo.entity.FlightInfo;
import com.cathay.demo.service.FerryTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class FerryTicketController {

    @Autowired
    private FerryTicketService ferryTicketService;

    @RequestMapping(path="/getFerryTicket", method = RequestMethod.GET)
    public List<FerryTicket> getFlightInfo(
        @RequestParam(name = "departureTime") String departureTime
    ){
        List<FerryTicket> ferryTicketList = ferryTicketService.getFerryTicket();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(ferryTicketList);
        return ferryTicketList;
    }

    @RequestMapping(path="/getBusTicket", method = RequestMethod.GET)
    public FerryTicket getBusTicket(){
        FerryTicket bus = new FerryTicket();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        bus.setPlanId("B015");
        bus.setDepartureTime(LocalDateTime.parse("2024-11-16 12:00:00", formatter));
        bus.setArrivalTime(LocalDateTime.parse("2024-11-16 13:40:00", formatter));
        bus.setDeparturePort("皇岗汽车站");
        bus.setArrivalPort("香港国际机场");
        bus.setOriginalPrice(BigDecimal.valueOf(80));
        bus.setDiscountedPrice(BigDecimal.valueOf(0));
        bus.setDestinationCode("HKG");
        bus.setDuration("1h40min");
        return bus;
    }

    @RequestMapping(path="/getRailwayTicket", method = RequestMethod.GET)
    public FerryTicket getRailwayTicket(){
        FerryTicket railway = new FerryTicket();
        railway.setPlanId("G5643");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        railway.setDepartureTime(LocalDateTime.parse("2024-11-16 12:08:00", formatter));
        railway.setArrivalTime(LocalDateTime.parse("2024-11-16 12:26:00", formatter));
        railway.setDeparturePort("深圳北站");
        railway.setArrivalPort("香港西九龙");
        railway.setDiscountedPrice(BigDecimal.valueOf(75));
        railway.setDuration("18min");
        return railway;
    }

    @RequestMapping(path="/getLimoTicket", method = RequestMethod.GET)
    public FerryTicket getLimoTicket(){
        FerryTicket taxi = new FerryTicket();
        taxi.setPlanId("商务车");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        taxi.setDepartureTime(LocalDateTime.parse("2024-11-16 12:35:00",formatter));
        taxi.setArrivalTime(LocalDateTime.parse("2024-11-16 13:35:00", formatter));
        taxi.setDeparturePort("南方科技大学");
        taxi.setArrivalPort("香港国际机场");
        taxi.setDiscountedPrice(BigDecimal.valueOf(750));
        taxi.setDuration("1h");
        return taxi;
    }


}
