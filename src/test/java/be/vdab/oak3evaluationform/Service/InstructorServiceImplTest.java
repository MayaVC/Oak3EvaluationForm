package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Instructor;
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

//    @After
//    public void clear() throws Exception {
//        if(!service.findAll().isEmpty()) {
//            for (Instructor i : service.findAll()) {
//                service.deleteInstructor(i);
//            }
//        }
//    }

    @Test
    public void testAddInstructor(){
        int i = service.addInstructor(instructor);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testDeleteInstructor(){
        service.addInstructor(instructor);
        int i = service.deleteInstructor(service.findAll().get(service.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testUpdateInstructor(){
        service.addInstructor(instructor);
        Instructor updatedInstructor = service.findAll().get(service.findAll().size() - 1);
        updatedInstructor.setName("Steengoed Inspring");
        int i = service.updateInstructor(updatedInstructor);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testFindAll(){
        instructors = service.findAll();
        assertThat(instructor).isNotNull();
    }

}