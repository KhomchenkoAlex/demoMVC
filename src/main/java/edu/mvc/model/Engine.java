package edu.mvc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private int capacity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Car car;

    public Engine(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    Engine(){}
}
