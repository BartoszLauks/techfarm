package pl.techfarmbackend.techfarmbackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.techfarmbackend.techfarmbackend.entity.Sensor;

import java.util.List;

@Repository
public class SensorRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Sensor> getAll() {
        return jdbcTemplate.query("SELECT id, series, model, greenHouse FROM sensor", BeanPropertyRowMapper.newInstance(Sensor.class));
    }

    public List<Sensor> save(List<Sensor> sensors) {
        sensors.forEach(sensor -> jdbcTemplate.update("INSERT INTO sensor(series, model, greenHouse) VALUES(?, ?, ?)",
        sensor.getSeries(), sensor.getModel(), sensor.getGreenHouse()));

        return sensors;
    }

    public Sensor findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, series, model, greenHouse FROM sensor WHERE id = ?", BeanPropertyRowMapper.newInstance(Sensor.class), id);
    }

}
