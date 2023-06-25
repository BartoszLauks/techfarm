package pl.techfarmbackend.techfarmbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {
    private int id;
    private int sensor;
    private String temperature;
    private String humidity;
    private String createdAt;
    
}
