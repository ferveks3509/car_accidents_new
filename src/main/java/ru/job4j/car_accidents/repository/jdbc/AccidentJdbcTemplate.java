package ru.job4j.car_accidents.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.job4j.car_accidents.model.Accident;
import ru.job4j.car_accidents.model.AccidentType;
import ru.job4j.car_accidents.model.Rule;
import ru.job4j.car_accidents.repository.repo.AccidentRepository;

import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class AccidentJdbcTemplate implements AccidentRepository {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public Accident add(Accident accident) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into accidents(name, text, address, type_id) VALUES (?,?,?,?)";
        jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, accident.getName());
            ps.setString(2, accident.getText());
            ps.setString(3, accident.getAddress());
            ps.setInt(4, accident.getAccidentType().getId());
            return ps;
        }, keyHolder);
        accident.setId(keyHolder.getKey().intValue());
        for (Rule rule : accident.getRules()) {
            jdbc.update("insert into accidents_rule(accident_id, rule_id) VALUES (?,?)",
                    accident.getId(),
                    rule.getId());
        }
        return accident;
    }

    @Override
    public boolean delete(int id) {
        final String sqlAccident = "delete from accidents where id = ?";
        final String sqlAcRule = "delete from accidents_rule where accident_id = ?";
        int ac = jdbc.update(sqlAccident, id);
        int rule = jdbc.update(sqlAcRule, id);
        return ac > 0 && rule > 0;
    }

    @Override
    public boolean replace(int id, Accident accident) {
        final String sqlUpdateAc = "update accidents set name = ?, text = ?, address = ?, type_id = ? where id = ?";
        final String sqlRule = "insert into accidents_rule(accident_id, rule_id) VALUES (?, ?)";
        final String sqlDelete = "delete from accidents_rule where accident_id = ?";

        jdbc.update(sqlUpdateAc,
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getAccidentType().getId(),
                id);
        jdbc.update(sqlDelete, id);
        for (Rule rule : accident.getRules()) {
            jdbc.update(sqlRule,
                    id,
                    rule.getId());
        }
        return true;
    }

    @Override
    public Collection<Accident> getAll() {
        final String sql = "select * from accidents";
        return jdbc.query(sql,
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    accident.setAccidentType(findById(rs.getInt("type_id")).get(0));
                    accident.setRules(new HashSet<>(findRuleByAccidentId(accident.getId())));
                    return accident;
                });
    }

    private List<AccidentType> findById(int id) {
        final String sql = "select * from type where id = ?";
        return jdbc.query(sql,
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                }, id);
    }

    private List<Rule> findRuleByAccidentId(int id) {
        final String sql = "select rule.id, rule.name from rule left join accidents_rule ar on rule.id = ar.rule_id where accident_id = ?";
        return jdbc.query(sql,
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                }, id);
    }
}
