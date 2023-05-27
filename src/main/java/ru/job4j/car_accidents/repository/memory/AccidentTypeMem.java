package ru.job4j.car_accidents.repository.memory;

import ru.job4j.car_accidents.model.AccidentType;

import java.util.ArrayList;
import java.util.List;

public class AccidentTypeMem {

    private List<AccidentType> accidentTypes = new ArrayList<>();

    private AccidentTypeMem() {
        accidentTypes.add(new AccidentType(1, "Две машины"));
        accidentTypes.add(new AccidentType(2, "Машина и человек"));
        accidentTypes.add(new AccidentType(3, "Машина и велосипед"));
    }

    public List<AccidentType> getAll() {
        return accidentTypes;
    }

    public AccidentType getById(int id) {
        return getAll().stream()
                .filter(accidentType -> accidentType.getId() == id)
                .findFirst().get();
    }
}
