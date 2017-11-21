package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    int deleteStudent(Student student);

    int updateStudent(Student student);

    List<Student> findAll();

}
