package com.cathay.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FlightInfo {
    private int flightId;
    private String flightNumber;
    private String departure;
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:mm")
    private LocalDateTime departureTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:mm")
    private LocalDateTime destinationTime;
    private BigDecimal price;
    private String flightClass;      // 舱位等级 Economy/Business
    private String flightDuration;
    private String departureCode;
    private String destinationCode;
}
