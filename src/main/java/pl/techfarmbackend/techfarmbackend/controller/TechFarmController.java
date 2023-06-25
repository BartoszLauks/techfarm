package pl.techfarmbackend.techfarmbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.techfarmbackend.techfarmbackend.entity.GreenHouse;
import pl.techfarmbackend.techfarmbackend.entity.Sensor;
import pl.techfarmbackend.techfarmbackend.entity.Statistic;
import pl.techfarmbackend.techfarmbackend.repository.GreenHouseRepository;
import pl.techfarmbackend.techfarmbackend.repository.SensorRepository;
import pl.techfarmbackend.techfarmbackend.repository.StatisticRepository;

@RestController
public class TechFarmController {

    @Autowired
    GreenHouseRepository greenHouseRepository;
    @Autowired
    SensorRepository sensorRepository;
    @Autowired
    StatisticRepository statisticRepository;

    @GetMapping("/t")
    public List<GreenHouse> getAllGreenHouse() {
        return greenHouseRepository.getAll();
    }

    @GetMapping("/s")
    public List<Sensor> getAllSensor() {
        return sensorRepository.getAll();
    }

    @GetMapping("/st")
    public List<Statistic> getAllStatistic() {
        System.out.println(statisticRepository.getAll());
        return statisticRepository.getAll();
    }
    
    // @PostMapping("/statistic")
    // public List<Statistic> add(@RequestBody List<Statistic> statistics) {
    //     //return statistics;
    //     return statisticRepository.save(statistics);
    // }

//     SELECT * FROM `statistic`
// INNER JOIN sensor on `statistic`.`sensor`=sensor.id
}