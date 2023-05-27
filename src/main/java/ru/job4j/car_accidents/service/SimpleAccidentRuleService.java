package ru.job4j.car_accidents.service;

import ru.job4j.car_accidents.model.Rule;

import java.util.Collection;
import java.util.Set;

public interface SimpleAccidentRuleService {
    Collection<Rule> getAll();
    Set<Rule> findById(String[] id);
}
