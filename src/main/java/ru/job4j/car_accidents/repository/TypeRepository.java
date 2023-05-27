package ru.job4j.car_accidents.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.car_accidents.model.AccidentType;

public interface TypeRepository extends CrudRepository<AccidentType, Integer> {
}
