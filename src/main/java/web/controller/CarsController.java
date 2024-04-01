package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.config.service.CarServiceImpl;
import web.models.Car;

import java.util.List;

@Controller
public class CarsController {
    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarsController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/cars")
    public String showCar(@RequestParam(name = "count", required = false, defaultValue = "0") int count,
                          Model model) {
        List<Car> cars;
        if (count < 1) {
            cars = carServiceImpl.getCars();
        } else {
            cars = carServiceImpl.getCarsByCount(count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
