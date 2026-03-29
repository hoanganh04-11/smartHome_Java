package com.smarthome.iot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smarthome.iot.domain.Sensor;


@Controller
public class SensorController {
    
    @GetMapping("/admin/sensor")
    public String getSensorPage(){
        return "admin/sensor/show";
    }

    @GetMapping("/admin/sensor/create")
    public String getSensorCreatePage(Model model) {
        model.addAttribute("newSensors", new Sensor());
        return "admin/sensor/create";
    }
    
}
