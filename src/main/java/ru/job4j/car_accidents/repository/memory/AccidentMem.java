package ru.job4j.car_accidents.repository.memory;

import ru.job4j.car_accidents.model.Accident;
import ru.job4j.car_accidents.model.AccidentType;
import ru.job4j.car_accidents.model.Rule;
import ru.job4j.car_accidents.repository.repo.AccidentRepository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccidentMem implements AccidentRepository {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    private AccidentMem() {
        add(new Accident(0, "test1", "text", "address",
                new AccidentType(1, "Две машины"),
                Set.of(
                        new Rule(1, "Статья. 1"),
                        new Rule(2, "Статья. 2"))));
        add(new Accident(0, "test2", "text", "address",
                new AccidentType(2, "Машина и человек"),
                Set.of(
                        new Rule(1, "Статья. 1"),
                        new Rule(3, "Статья. 3"))));
        add(new Accident(0, "test3", "text", "address",
                new AccidentType(3, "Машина и велосипед"),
                Set.of(new Rule(1, "Статья. 1"))));
    }

    @Override
    public Accident add(Accident accident) {
        accident.setId(nextId.getAndIncrement());
        accidents.put(accident.getId(), accident);
        return accident;
    }

    @Override
    public boolean delete(int id) {
        return accidents.remove(id) != null;
    }

    @Override
    public boolean replace(int id, Accident accident) {
        return accidents.replace(id, accident) != null;
    }

    @Override
    public Collection<Accident> getAll() {
        return accidents.values();
    }
}
