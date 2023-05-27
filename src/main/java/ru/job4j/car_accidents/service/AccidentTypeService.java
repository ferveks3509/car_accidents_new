package ru.job4j.car_accidents.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accidents.model.AccidentType;
import ru.job4j.car_accidents.repository.TypeRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccidentTypeService {
    private final TypeRepository accidentTypeRepository;

    public AccidentTypeService(TypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    public Collection<AccidentType> getAll() {
        List<AccidentType> rsl = new ArrayList<>();
        accidentTypeRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public AccidentType findById(int id) {
        return accidentTypeRepository.findById(id).get();
    }
}
