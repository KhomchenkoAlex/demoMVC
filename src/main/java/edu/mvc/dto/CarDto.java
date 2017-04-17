package edu.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarDto {
    private int id;
    private String carName;
    private String engineName;
    private int engineCapacity;
    private String wheelName;
    private int wheelSize;
    private String tyreSeasonType;
}
