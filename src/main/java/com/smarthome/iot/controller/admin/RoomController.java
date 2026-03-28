package com.smarthome.iot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {
    
    @GetMapping("/admin/room")
    public String getRoomPage(){
        return "admin/room/show";
    }
}
