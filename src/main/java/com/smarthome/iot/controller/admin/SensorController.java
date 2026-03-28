package com.smarthome.iot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SensorController {
    
    @GetMapping("/admin/sensor")
    public String getSensorPage(){
        return "admin/sensor/show";
    }
}
