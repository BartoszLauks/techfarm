package pl.techfarmbackend.techfarmbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    private int id;
    private String series;
    private String model;
    private int greenHouse;
}
