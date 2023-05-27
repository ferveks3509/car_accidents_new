package ru.job4j.car_accidents.service;

import ru.job4j.car_accidents.model.Accident;

import java.util.Collection;

public interface SimpleAccidentService {
    Accident add(Accident accident);
    boolean delete(int id);
    boolean replace(int id, Accident accident);
    Collection<Accident> getAll();
}
