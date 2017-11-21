package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Instructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class InstructorServiceImplTest {


    private List<Instructor> instructors;
    private Instructor instructor;

    @Autowired
    private InstructorService service;

    @Before
    public void init() throws Exception {
        instructor = new Instructor();
        instructor.setName("Kei Injava");
    }

    @After
    public void clear() throws Exception {
        if(!service.findAll().isEmpty()) {
            for (Instructor i : service.findAll()) {
                service.deleteInstructor(i);
            }
        }
    }

    @Test
    public void testAddInstructor(){

    }

    @Test
    public void testDeleteInstructor(){

    }

    @Test
    public void testUpdateInstructor(){

    }

    @Test
    public void testFindAll(){

    }

}