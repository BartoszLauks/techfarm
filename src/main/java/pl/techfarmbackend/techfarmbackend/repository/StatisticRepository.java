package pl.techfarmbackend.techfarmbackend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.techfarmbackend.techfarmbackend.entity.Statistic;

@Repository
public class StatisticRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Statistic> getAll() {
        return jdbcTemplate.query("SELECT id, sensor, temperature, humidity, createdAt FROM statistic", BeanPropertyRowMapper.newInstance(Statistic.class));
    }

    public List<Statistic> save(List<Statistic> statistics) {
         statistics.forEach(statistic -> jdbcTemplate.update("INSERT INTO statistic(sensor, temperature, humidity) VALUES(?, ?, ?)",
         statistic.getSensor(), statistic.getTemperature(), statistic.getHumidity()));

         return statistics;
    }

    public List<Statistic> findBySensorId(int id) {
        return jdbcTemplate.query("SELECT id, sensor, temperature, humidity, createdAt FROM statistic WHERE id = ?",
         BeanPropertyRowMapper.newInstance(Statistic.class), id);
        // return jdbcTemplate.queryForObject("SELECT id, sensor, temperature, humidity, createdAt FROM statistic WHERE sensor.id = ?",
        //  BeanPropertyRowMapper.newInstance(Statistic.class), id);
    }

    public List<Statistic> findByGreenHouse(int id) {
        return jdbcTemplate.query("SELECT statistic.id, statistic.sensor, statistic.temperature, statistic.humidity, statistic.createdAt from statistic INNER JOIN sensor on statistic.sensor=sensor.id INNER JOIN green_house on sensor.greenHouse=green_house.id and green_house.id = ?",
        BeanPropertyRowMapper.newInstance(Statistic.class), id);
    }
}
