package com.cathay.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FerryTicket {
    private int id;
    private String planId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:mm")
    private LocalDateTime departureTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:mm")
    private LocalDateTime arrivalTime;
    private String departurePort;
    private String arrivalPort;
    private BigDecimal originalPrice;
    private BigDecimal discountedPrice;
    private String departureCode;
    private String destinationCode;
    private String duration;

}
