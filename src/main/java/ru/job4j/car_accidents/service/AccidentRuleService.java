package ru.job4j.car_accidents.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accidents.model.Rule;
import ru.job4j.car_accidents.repository.RuleRepository;

import java.util.*;

@Service
public class AccidentRuleService {
    private final RuleRepository ruleRepository;

    public AccidentRuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public Collection<Rule> getAll() {
        List<Rule> rsl = new ArrayList<>();
        ruleRepository.findAll().forEach(rsl::add);
        return rsl;
    }


    public Set<Rule> findById(String[] id) {
        Set<Rule> rules = new HashSet<>();
        for (String el : id) {
            rules.add(ruleRepository.findById(Integer.parseInt(el)).get());
        }
        return rules;
    }
}
