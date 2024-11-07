package com.cathay.demo.service;

import com.cathay.demo.dao.FerryTicketMapper;
import com.cathay.demo.entity.FerryTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerryTicketService {

    @Autowired
    private FerryTicketMapper ferryTicketMapper;

    public List<FerryTicket> getFerryTicket(){
        return ferryTicketMapper.selectFerryTicket();
    }
}
