package ru.job4j.car_accidents.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.car_accidents.model.Rule;

public interface RuleRepository extends CrudRepository<Rule, Integer> {
}
