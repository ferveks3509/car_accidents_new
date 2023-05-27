package ru.job4j.car_accidents.service;

import ru.job4j.car_accidents.model.AccidentType;

import java.util.Collection;

public interface SimpleAccidentTypeService {
    Collection<AccidentType> getAll();
    AccidentType findById(int id);
}
