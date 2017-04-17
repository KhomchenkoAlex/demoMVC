package edu.mvc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wheel")
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private int size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tyres_id")
    private Tyre tyre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public Wheel(String name, int size, Tyre tyre) {
        this.name = name;
        this.size = size;
        this.tyre = tyre;
    }

    Wheel(){}

}
