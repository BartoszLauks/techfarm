package pl.techfarmbackend.techfarmbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.techfarmbackend.techfarmbackend.entity.Sensor;
import pl.techfarmbackend.techfarmbackend.repository.SensorRepository;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    SensorRepository sensorRepository;
    
    @GetMapping("")
    public List<Sensor> getAllSensor() {
        return sensorRepository.getAll();
    }

    @GetMapping("/{id}")
    public Sensor getById(@PathVariable("id") int id) {
        return sensorRepository.findById(id);
    }
}
