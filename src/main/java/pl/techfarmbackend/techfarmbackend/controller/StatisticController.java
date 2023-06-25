package pl.techfarmbackend.techfarmbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.techfarmbackend.techfarmbackend.entity.Statistic;
import pl.techfarmbackend.techfarmbackend.repository.StatisticRepository;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    StatisticRepository statisticRepository;

    @PostMapping("")
    public int add(@RequestBody List<Statistic> statistics) {
        statisticRepository.save(statistics);
        return 200;
    }

    @GetMapping("")
    public List<Statistic> getAllStatistic() {
        System.out.println(statisticRepository.getAll());
        return statisticRepository.getAll();
    }

    @GetMapping("/sensor/{id}")
    public List<Statistic> sensorStatistic(@PathVariable("id") int id) {
        return statisticRepository.findBySensorId(id);
    }

    @GetMapping("/greenHouse/{id}")
    public List<Statistic> greenHouseStatistic(@PathVariable("id") int id) {
        return statisticRepository.findByGreenHouse(id);
    }
    
}
