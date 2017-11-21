package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;

import java.util.List;

public interface CourseService {

    int addCourse(Course course);

    int deleteCourse(Course course);

    int updateCourse(Course course);

    List<Course> findAll();

}
