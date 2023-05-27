package ru.job4j.car_accidents.repository.hibernate;

import org.hibernate.SessionFactory;
import ru.job4j.car_accidents.model.Accident;
import ru.job4j.car_accidents.repository.repo.AccidentRepository;

import java.util.Collection;


public class AccidentHibernate implements AccidentRepository {
    private SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Accident add(Accident accident) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean replace(int id, Accident accident) {
        return false;
    }

    @Override
    public Collection<Accident> getAll() {
        return null;
    }
}
