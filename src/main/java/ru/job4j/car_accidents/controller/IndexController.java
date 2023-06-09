package ru.job4j.car_accidents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.car_accidents.service.AccidentService;

@Controller
public class IndexController {

    private AccidentService accidentService;

    public IndexController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("accidents", accidentService.getAll());
        return "index";
    }
}
