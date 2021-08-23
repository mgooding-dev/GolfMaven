package golferData;

import golferModel.Golfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class GolferJdbcDAO implements GolferDAO{

    private final JdbcTemplate template;

    public GolferJdbcDAO(DataSource ds) {

        this.template = new JdbcTemplate(ds);
    }

    @Override
    public List<Golfer> getAllGolfers() {

        String sql = "SELECT golfer_id, golfer_firstname, golfer_lastname, handedness, gender, has_handicap FROM golfer";
        SqlRowSet results = template.queryForRowSet(sql);
        List<Golfer> golfers = new ArrayList<>();

        while (results.next()) {

            Golfer golfer = mapRowToGolfer(results);
            golfers.add(golfer);
        }
        return golfers;
    }

    @Override
    public Golfer getGolfer(int id) {

        String sql = "SELECT golfer_id, golfer_firstname, golfer_lastname, handedness, gender, handicap " +
                "FROM golfer " +
                "WHERE golfer_id = ?";
        SqlRowSet results = template.queryForRowSet(sql);

        return mapRowToGolfer(results);

    }

    @Override
    public void saveGolfer(Golfer golferToSave) {

    }

    private Golfer mapRowToGolfer(SqlRowSet results) {

        Golfer golfer = new Golfer();
        golfer.setGolferId(results.getInt("golfer_id"));
        golfer.setGolferFirstName(results.getString("golfer_firstname"));
        golfer.setGolferLastName(results.getString("golfer_lastname"));
        golfer.setHandedness(results.getString("handedness"));
        golfer.setGender(results.getString("gender"));
        golfer.setHasHandicap(results.getBoolean("has_handicap"));

        return golfer;
    }
}
