package ru.job4j.car_accidents.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.job4j.car_accidents.model.Rule;
import ru.job4j.car_accidents.repository.repo.AccidentRuleRepository;

import java.util.Collection;
import java.util.List;

public class AccidentRuleJdbcTemplate implements AccidentRuleRepository {
    private final JdbcTemplate jdbc;

    public AccidentRuleJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Collection<Rule> getAll() {
        return jdbc.query("select id, name from rule",
                (rs, row) -> {
            Rule rule = new Rule();
            rule.setId(rs.getInt("id"));
            rule.setName(rs.getString("name"));
            return rule;
                });
    }

    @Override
    public List<Rule> findById(int id) {
        final String sql = "select * from rule where id = ?";
        return jdbc.query(sql,
                (rs,row) -> {
            Rule rule = new Rule();
            rule.setId(rs.getInt("id"));
            rule.setName(rs.getString("name"));
            return rule;
                }, id);
    }
}
