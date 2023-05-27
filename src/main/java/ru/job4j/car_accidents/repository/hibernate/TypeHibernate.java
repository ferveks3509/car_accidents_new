package ru.job4j.car_accidents.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.car_accidents.model.AccidentType;
import ru.job4j.car_accidents.repository.repo.AccidentTypeRepository;

import java.util.List;

public class TypeHibernate implements AccidentTypeRepository {
    private final SessionFactory sf;

    public TypeHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<AccidentType> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType ", AccidentType.class)
                    .getResultList();
        }
    }

    @Override
    public List<AccidentType> getById(int id) {
        return null;
    }
}
