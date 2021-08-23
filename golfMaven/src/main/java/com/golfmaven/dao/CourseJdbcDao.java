package com.golfmaven.dao;

import com.golfmaven.models.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseJdbcDao implements CourseDao{

    private final JdbcTemplate jdbcTemplate;

    public CourseJdbcDao(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public Course create(Course course) {
        String sql = "INSERT INTO course (course_name, location_city, location_state, " +
                "location_country, par_f9, par_b9, par_18, hcap_1, hcap_2) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING course_id";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, course.getCourseName(),
                course.getLocationCity(), course.getLocationState(), course.getLocationCountry(),
                course.getParF9(), course.getParB9(), course.getPar18(),
                course.getHandicap1(), course.getHandicap2());
        course = getCourseById(id);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        String sql = "SELECT course_id, course_name, location_city, location_state," +
                " location_country, par_f9, par_b9, par_18, hcap_1, hcap_2 FROM course";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Course> courses = new ArrayList<>();

        while (results.next()) {

            Course course = mapRowToCourse(results);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Course getCourseById(int id) {

        String sql = "SELECT course_id, course_name, location_city, location_state," +
                " location_country, par_f9, par_b9, par_18, hcap_1, hcap_2 FROM course " +
                "WHERE course_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        return mapRowToCourse(results);
    }

    @Override
    public Course update(Course course, int id) {
        String sql = "UPDATE course SET course_name, location_city, location_state, " +
                "location_country, par_f9, par_b9, par_18, hcap_1, hcap_2 " +
                "WHERE course_id = ?";
        jdbcTemplate.update(sql, course.getCourseName(), course.getLocationCity(), course.getLocationState(),
                course.getLocationCountry(), course.getParF9(), course.getParB9(), course.getPar18(),
                course.getHandicap1(), course.getHandicap2());
        course = getCourseById(id);

        return course;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM course WHERE course_id = ?";
        return  jdbcTemplate.update(sql, id)  == 1;
    }

    private Course mapRowToCourse(SqlRowSet results) {

        Course course = new Course();
        course.setCourseId(results.getInt("course_id"));
        course.setCourseName(results.getString("course_name"));
        course.setLocationCity(results.getString("location_city"));
        course.setLocationState(results.getString("location_state"));
        course.setLocationCountry(results.getString("location_country"));
        course.setParF9(results.getInt("par_f9"));
        course.setParB9(results.getInt("par_b9"));
        course.setPar18(results.getInt("par_18"));
        course.setHandicap1(results.getInt("hcap_1"));
        course.setHandicap2(results.getInt("hcap_2"));

        return course;
    }
}
