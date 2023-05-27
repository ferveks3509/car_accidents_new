package ru.job4j.car_accidents.repository.repo;

import ru.job4j.car_accidents.model.Rule;

import java.util.Collection;
import java.util.List;

public interface AccidentRuleRepository {
    Collection<Rule> getAll();
    List<Rule> findById(int id);
}
