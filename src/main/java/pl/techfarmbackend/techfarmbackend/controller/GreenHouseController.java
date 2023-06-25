package pl.techfarmbackend.techfarmbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.techfarmbackend.techfarmbackend.entity.GreenHouse;
import pl.techfarmbackend.techfarmbackend.repository.GreenHouseRepository;

@RestController
@RequestMapping("/greenHouse")
public class GreenHouseController {

    @Autowired
    GreenHouseRepository greenHouseRepository;

    @GetMapping("")
    public List<GreenHouse> getAllGreenHouse() {
        return greenHouseRepository.getAll();
    }

    @GetMapping("/{id}")
    public GreenHouse getById(@PathVariable("id") int id) {
        return greenHouseRepository.findById(id);
        // GreenHouse result = greenHouseRepository.findById(id);
        // if (result == null) {
        //     return null;
        // }
        // return result;
    }
}
