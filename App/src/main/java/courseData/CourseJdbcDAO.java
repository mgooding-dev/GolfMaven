package courseData;

import courseModel.Course;
import golferModel.Golfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class CourseJdbcDAO implements CourseDAO{

    private final JdbcTemplate template;

    public CourseJdbcDAO(DataSource ds) {

        this.template = new JdbcTemplate(ds);
    }

    @Override
    public List<Course> getAllCourses() {

        String sql = "SELECT course_id, course_name, location_city, location_state," +
                " location_country, par_f9, par_b9, par_18, hcap_1, hcap_2 FROM course";
        SqlRowSet results = template.queryForRowSet(sql);
        List<Course> courses = new ArrayList<>();

        while (results.next()) {

            Course course = mapRowToCourse(results);
            courses.add(course);
        }
        return courses;

    }

    @Override
    public Course getCourse(int id) {
        return null;
    }

    @Override
    public void saveCourse(Course courseToSave) {

    }

    private Course mapRowToCourse(SqlRowSet results) {

        Course course = new Course();
        course.setCourseId(results.getInt("course_id"));
        course.setCourseLocation(results.getString("location_city") + ", " +
                results.getString("location_state") + " " + results.getString("location_country"));
        course.setParF9(results.getInt("par_f9"));
        course.setParB9(results.getInt("par_b9"));
        course.setHandicap1(results.getInt("hcap_1"));
        course.setHandicap2(results.getInt("hcap_2"));

        return course;
    }
}
