package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Instructor;

import java.util.List;

public interface InstructorService {

    int addInstructor(Instructor instructor);

    int deleteInstructor(Instructor instructor);

    int updateInstructor(Instructor instructor);

    List<Instructor> findAll();
}
