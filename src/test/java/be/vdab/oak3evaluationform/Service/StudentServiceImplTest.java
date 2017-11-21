package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {


    private List<Student> students;
    private Student student;

    @Autowired
    private StudentService service;

    @Before
    public void init() {
        student = new Student();
        student.setName("Noob");
        student.seteMail("javanoob@losers.com");
        student.setFirstName("Java");
    }

    @After
    public void clear() {
        if(!service.findAll().isEmpty()) {
            for (Student s : service.findAll()) {
                service.deleteStudent(s);
            }
        }
    }

    @Test
    public void testAddStudent(){

    }

    @Test
    public void testDeleteStudent(){

    }

    @Test
    public void testUpdateStudent(){

    }

    @Test
    public void testFindAll(){

    }

}