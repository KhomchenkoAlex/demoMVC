package edu.mvc.controller;

import edu.mvc.dto.CarDto;
import edu.mvc.model.Car;
import edu.mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String getList(Model model) {
        List<CarDto> dtos = new ArrayList<>();
        carService.findAll().forEach(car -> {
            dtos.add(carService.buildCarDto(car));
        });
        model.addAttribute("cars", dtos);
        model.addAttribute("carDto", new CarDto());
        return "CarManager";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute("carDto") CarDto carDto) {
        Car car = carService.buildCar(carDto);
        carService.save(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        carService.deleteById(id);
        return "redirect:/";
    }
}