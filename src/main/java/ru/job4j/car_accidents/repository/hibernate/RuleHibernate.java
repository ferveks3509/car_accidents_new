package ru.job4j.car_accidents.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.car_accidents.model.Rule;
import ru.job4j.car_accidents.repository.repo.AccidentRuleRepository;

import java.util.Collection;
import java.util.List;


public class RuleHibernate implements AccidentRuleRepository {
    private SessionFactory sf;

    public RuleHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Collection<Rule> getAll() {
        try(Session session = sf.openSession()) {
            return session.createQuery("from Rule ", Rule.class)
                    .getResultList();
        }
    }

    @Override
    public List<Rule> findById(int id) {
        return null;
    }
}
