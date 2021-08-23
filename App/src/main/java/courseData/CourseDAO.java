package courseData;

import courseModel.Course;

import java.util.List;

public interface CourseDAO {

    public List<Course> getAllCourses();
    public Course getCourse(int id);
    public void saveCourse(Course courseToSave);
}
