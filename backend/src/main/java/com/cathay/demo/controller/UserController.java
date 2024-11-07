package com.cathay.demo.controller;

import com.cathay.demo.entity.User;
import com.cathay.demo.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path="/getUserInfo", method = RequestMethod.GET)
    public User getUserInfo(@RequestParam(name = "member_id") int memberId){
        User user = userService.findUserByMemberId(memberId);
        System.out.println(user);
        return user;
    }
}
