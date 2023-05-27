package ru.job4j.car_accidents.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.car_accidents.model.Accident;

import java.util.Collection;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @Query("select distinct a from Accident a left join fetch a.rules order by  a.id")
    Collection<Accident> findAll();
}
