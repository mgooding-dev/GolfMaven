package com.golfmaven.dao;

import com.golfmaven.models.Golfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class GolferJdbcDAO implements GolferDao{

    private final JdbcTemplate jdbcTemplate;

    public GolferJdbcDAO(DataSource ds) {

        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public Golfer create(Golfer golfer) {
        String sql = "INSERT INTO golfer (golfer_firstname, golfer_lastname, handedness, gender, teebox_choice, has_handicap) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING golfer_id";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, golfer.getGolferFirstName(), golfer.getGolferLastName(),
                golfer.getHandedness(), golfer.getGender(), golfer.getTeeBoxChoice(), golfer.isHasHandicap());
        golfer = getGolferById(id);
        return golfer;
    }

    @Override
    public List<Golfer> getAllGolfers() {

        String sql = "SELECT golfer_id, golfer_firstname, golfer_lastname, handedness, gender, has_handicap FROM golfer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Golfer> golfers = new ArrayList<>();

        while (results.next()) {

            Golfer golfer = mapRowToGolfer(results);
            golfers.add(golfer);
        }
        return golfers;
    }

    @Override
    public Golfer getGolferById(int id) {

        String sql = "SELECT golfer_id, golfer_firstname, golfer_lastname, handedness, gender, teebox_choice, has_handicap " +
                "FROM golfer " +
                "WHERE golfer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        return mapRowToGolfer(results);

    }

    @Override
    public Golfer update(Golfer golfer, int id) {
        String sql = "UPDATE golfer SET golfer_firstname, golfer_lastname, handedness, gender, teebox_choice, has_handicap " +
                "WHERE golfer_id = ?";
        jdbcTemplate.update(sql, golfer.getGolferFirstName(), golfer.getGolferLastName(), golfer.getHandedness(),
                golfer.getGender(), golfer.getTeeBoxChoice(), golfer.isHasHandicap());
        golfer = getGolferById(id);

        return golfer;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM golfer WHERE golfer_id = ?";
        return jdbcTemplate.update(sql, id) == 1;
     }

    private Golfer mapRowToGolfer(SqlRowSet results) {

        Golfer golfer = new Golfer();
        golfer.setGolferId(results.getInt("golfer_id"));
        golfer.setGolferFirstName(results.getString("golfer_firstname"));
        golfer.setGolferLastName(results.getString("golfer_lastname"));
        golfer.setHandedness(results.getString("handedness"));
        golfer.setGender(results.getString("gender"));
        golfer.setTeeBoxChoice(results.getString("teebox_choice"));
        golfer.setHasHandicap(results.getBoolean("has_handicap"));

        return golfer;
    }
}
