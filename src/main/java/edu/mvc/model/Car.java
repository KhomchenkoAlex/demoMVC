package edu.mvc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wheel_id")
    private Wheel wheel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    public Car(String name, Wheel wheel, Engine engine) {
        this.name = name;
        this.wheel = wheel;
        this.engine = engine;
    }

    Car(){}

}
