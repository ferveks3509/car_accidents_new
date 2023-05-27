package ru.job4j.car_accidents.repository.repo;

import ru.job4j.car_accidents.model.Accident;

import java.util.Collection;

public interface AccidentRepository {
    Accident add(Accident accident);
    boolean delete(int id);
    boolean replace(int id, Accident accident);
    Collection<Accident> getAll();
}
