package ru.job4j.car_accidents.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accidents.model.Accident;
import ru.job4j.car_accidents.repository.AccidentRepository;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;

    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public Accident add(Accident accident) {
        return accidentRepository.save(accident);
    }

    public void delete(int id) {
        accidentRepository.deleteById(id);
    }

    public boolean replace(int id, Accident accident) {
        return add(accident) == null;
    }

    public Collection<Accident> getAll() {
        return accidentRepository.findAll();
    }
}
