package pl.techfarmbackend.techfarmbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.techfarmbackend.techfarmbackend.entity.GreenHouse;
import pl.techfarmbackend.techfarmbackend.entity.Sensor;
import pl.techfarmbackend.techfarmbackend.repository.GreenHouseRepository;
import pl.techfarmbackend.techfarmbackend.repository.SensorRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    GreenHouseRepository greenHouseRepository;
    @Autowired
    SensorRepository sensorRepository;

    @PostMapping("/greenHouse")
    public int addGreenHouse(@RequestBody List<GreenHouse> greenHouses) {
        greenHouseRepository.save(greenHouses);
        return 200;
    }

    @PostMapping("/sensor")
    public int addSensor(@RequestBody List<Sensor> sensors) {
        sensorRepository.save(sensors);
        return 200;
    }
}
