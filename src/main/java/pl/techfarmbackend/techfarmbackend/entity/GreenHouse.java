package pl.techfarmbackend.techfarmbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreenHouse {
    private int id;
    private String city;
    private String street;
    private String postCode;
    private String houseNumber;
}
