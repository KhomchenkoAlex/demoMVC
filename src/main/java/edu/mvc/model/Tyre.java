package edu.mvc.model;



import edu.mvc.enums.SeasonType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tyre")
public class Tyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seasontype")
    private SeasonType seasonType;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Wheel wheel;

    public Tyre(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    Tyre(){}

}

