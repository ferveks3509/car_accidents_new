package ru.job4j.car_accidents.repository.memory;

import ru.job4j.car_accidents.model.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccidentRuleMem{
    private List<Rule> rules = new ArrayList<>();

    private AccidentRuleMem() {
        rules.add(new Rule(1, "Статья. 1"));
        rules.add(new Rule(2, "Статья. 2"));
        rules.add(new Rule(3, "Статья. 3"));
    }

    public Collection<Rule> getAll() {
        return rules;
    }

    public Rule findById(int id) {
        return rules.stream()
                .filter(rule -> rule.getId() == id)
                .findFirst().get();
    }
}
