package edu.mvc.config;

import edu.mvc.enums.SeasonType;
import edu.mvc.model.Car;
import edu.mvc.model.Engine;
import edu.mvc.model.Tyre;
import edu.mvc.model.Wheel;
import edu.mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
public class Bootstrap {
    @Autowired
    private CarService carService;

    @PostConstruct
    public void initCar(){

        IntStream.range(1, 4).forEach(elem ->{
            Engine engine = new Engine("CSD123ZX"+elem, 100+elem*5);
            Tyre tyre = new Tyre(SeasonType.WINTER);
            Wheel wheel = new Wheel("Nokian", 14+elem, tyre);
            carService.save(new Car("Dodge"+elem, wheel, engine));
        });
    }
}
