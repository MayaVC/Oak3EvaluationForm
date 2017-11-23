package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Student;
import be.vdab.oak3evaluationform.Model.Topic;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    int deleteStudent(Student student);

    int updateStudent(Student student);

    List<Student> findAll();

    Student findOne(int id);

}
