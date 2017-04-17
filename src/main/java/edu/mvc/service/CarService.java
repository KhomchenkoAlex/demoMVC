package edu.mvc.service;

import edu.mvc.dto.CarDto;
import edu.mvc.enums.SeasonType;
import edu.mvc.model.Car;
import edu.mvc.model.Engine;
import edu.mvc.model.Tyre;
import edu.mvc.model.Wheel;
import edu.mvc.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void deleteById(Integer id) {
        carRepository.delete(id);
    }

    public CarDto buildCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setCarName(car.getName());
        carDto.setEngineName(car.getEngine().getName());
        carDto.setEngineCapacity(car.getEngine().getCapacity());
        carDto.setWheelName(car.getWheel().getName());
        carDto.setWheelSize(car.getWheel().getSize());
        carDto.setTyreSeasonType(car.getWheel().getTyre().getSeasonType().toString());
        return carDto;
    }

    public Car buildCar(CarDto carDto) {

        Engine engine = new Engine(carDto.getEngineName(), carDto.getEngineCapacity());
        Tyre tyre = new Tyre(SeasonType.valueOf(carDto.getTyreSeasonType()));
        Wheel wheel = new Wheel(carDto.getWheelName(), carDto.getWheelSize(), tyre);
        Car car = new Car(carDto.getCarName(), wheel, engine);
        return car;
    }
}
