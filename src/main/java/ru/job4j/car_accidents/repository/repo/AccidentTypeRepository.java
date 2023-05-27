package ru.job4j.car_accidents.repository.repo;

import ru.job4j.car_accidents.model.AccidentType;

import java.util.List;

public interface AccidentTypeRepository {
    List<AccidentType> getAll();
    List<AccidentType> getById(int id);
}
