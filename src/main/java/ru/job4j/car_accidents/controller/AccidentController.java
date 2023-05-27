package ru.job4j.car_accidents.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.car_accidents.model.Accident;
import ru.job4j.car_accidents.service.AccidentRuleService;
import ru.job4j.car_accidents.service.AccidentService;
import ru.job4j.car_accidents.service.AccidentTypeService;

@Controller
@RequestMapping("/accidents")
public class AccidentController {
    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;
    private final AccidentRuleService accidentRuleService;

    public AccidentController(AccidentService accidentService,
                              AccidentTypeService accidentTypeService,
                              AccidentRuleService accidentRuleService) {
        this.accidentService = accidentService;
        this.accidentTypeService = accidentTypeService;
        this.accidentRuleService = accidentRuleService;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("types", accidentTypeService.getAll());
        model.addAttribute("rules", accidentRuleService.getAll());
        return "accidents/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Accident accident, HttpServletRequest request) {
        var typeId = Integer.parseInt(request.getParameter("type.id"));
        String[] ids = request.getParameterValues("rIds");
        accident.setRules(accidentRuleService.findById(ids));
        accident.setAccidentType(accidentTypeService.findById(typeId));
        accidentService.add(accident);
        return "redirect:/";
    }

    @GetMapping("/replace")
    public String viewReplace(Model model) {
        model.addAttribute("types", accidentTypeService.getAll());
        model.addAttribute("rules", accidentRuleService.getAll());
        return "accidents/replace";
    }

    @PostMapping("/replace")
    public String replace(@ModelAttribute Accident accident, HttpServletRequest request) {
        var typeId = Integer.parseInt(request.getParameter("type.id"));
        String[] ids = request.getParameterValues("rIds");
        accident.setRules(accidentRuleService.findById(ids));
        accident.setAccidentType(accidentTypeService.findById(typeId));
        accidentService.replace(accident.getId(), accident);
        return "redirect:/";
    }
}
