package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Student;
import be.vdab.oak3evaluationform.Oak3evaluationformApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Oak3evaluationformApplication.class)
@ActiveProfiles("marco")
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

//    @After
//    public void clear() {
//        if(!service.findAll().isEmpty()) {
//            for (Student s : service.findAll()) {
//                service.deleteStudent(s);
//            }
//        }
//    }

    @Test
    public void testAddStudent(){
        int i = service.addStudent(student);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testDeleteStudent(){
        service.addStudent(student);
        int i = service.deleteStudent(service.findAll().get(service.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testUpdateStudent(){
        service.addStudent(student);
        Student updatedStudent = service.findAll().get(service.findAll().size() - 1);
        updatedStudent.setName("Desnoozer");
        updatedStudent.setFirstName("Loser");
        updatedStudent.seteMail("loser@loserville.com");
        int i = service.updateStudent(updatedStudent);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testFindAll(){
        students = service.findAll();
        assertThat(student).isNotNull();
    }

}