package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Student;
import be.vdab.oak3evaluationform.Repository.StudentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentJPARepository studentJPARepository;

    @Autowired
    public StudentServiceImpl(StudentJPARepository studentJPARepository) {
        this.studentJPARepository = studentJPARepository;
    }

    @Override
    public int addStudent(Student student) {
        Student s = studentJPARepository.saveAndFlush(student);
        return s != null ? 1 : 0;
    }

    @Override
    public int deleteStudent(Student student) {
        if(studentJPARepository.exists(student.getId())){
            studentJPARepository.delete(student);
        studentJPARepository.delete(student);}
        return studentJPARepository.exists(student.getId())?1:0 ;
    }

    @Override
    public int updateStudent(Student student) {
        Student updatedStudent = null;
        if (studentJPARepository.exists(student.getId())) {
            updatedStudent = studentJPARepository.saveAndFlush(student);
       }
     return updatedStudent==null ? 0 : 1;
    }

    @Override
    public List<Student> findAll() {
        return studentJPARepository.findAll();
    }
}
