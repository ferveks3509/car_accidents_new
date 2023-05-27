package ru.job4j.car_accidents.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.job4j.car_accidents.model.AccidentType;
import ru.job4j.car_accidents.repository.repo.AccidentTypeRepository;

import java.util.List;


public class AccidentTypeJdbcTemplate implements AccidentTypeRepository {
    private final JdbcTemplate jdbc;

    public AccidentTypeJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<AccidentType> getAll() {
        final String sql = "select * from type";
        return jdbc.query(sql,
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                });
    }

    @Override
    public List<AccidentType> getById(int id) {
        final String sql = "select * from type where type.id = ?";
        return jdbc.query(sql,
                (rs, row) -> {
            AccidentType accidentType = new AccidentType();
            accidentType.setId(rs.getInt("id"));
            accidentType.setName(rs.getString("name"));
            return accidentType;
                }, id);
    }
}
