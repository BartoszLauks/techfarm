package pl.techfarmbackend.techfarmbackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.techfarmbackend.techfarmbackend.entity.GreenHouse;

import java.util.List;

@Repository
public class GreenHouseRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<GreenHouse> getAll() {
        return jdbcTemplate.query("SELECT id, city, street, postCode, houseNumber FROM green_house", BeanPropertyRowMapper.newInstance(GreenHouse.class));
    }

    public List<GreenHouse> save(List<GreenHouse> greenHouses) {
        greenHouses.forEach(arg -> jdbcTemplate
        .update("INSERT INTO green_house(city, street, postCode, houseNumber) VALUES(?, ?, ?, ?)", 
        arg.getCity(), arg.getStreet(), arg.getPostCode(), arg.getHouseNumber()));

        return greenHouses;
    }

    public GreenHouse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, city, street, postCode, houseNumber FROM green_house WHERE id = ?", BeanPropertyRowMapper.newInstance(GreenHouse.class), id);
    }
}