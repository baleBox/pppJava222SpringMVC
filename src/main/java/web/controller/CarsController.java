package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarServiceImpl;


@Controller
public class CarsController {
    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarsController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/cars")
    public String showCar(@RequestParam(name = "count", required = false, defaultValue = "5") int count,
                          Model model) {

        model.addAttribute("cars", carServiceImpl.getCars(count));
        return "cars";
    }
}
