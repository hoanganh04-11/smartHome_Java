package com.smarthome.iot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeviceController {
    
    @GetMapping("/admin/device")
    public String getDevicePage(){
        return "admin/device/show";
    }
}
