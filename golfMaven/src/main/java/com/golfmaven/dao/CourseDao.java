package com.golfmaven.dao;

import com.golfmaven.models.Course;
import com.golfmaven.models.Golfer;

import java.util.List;

public interface CourseDao {

    // CREATE
    Course create(Course course);

    // READ
    List<Course> getAllCourses();

    Course getCourseById(int id);

    // UPDATE
    Course update(Course course, int id);

    // DELETE
    boolean delete(int id);
}
