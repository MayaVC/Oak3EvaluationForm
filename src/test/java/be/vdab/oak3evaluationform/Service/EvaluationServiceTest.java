package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Evaluation;
import be.vdab.oak3evaluationform.Model.Instructor;
import be.vdab.oak3evaluationform.Model.Student;
import be.vdab.oak3evaluationform.Oak3evaluationformApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class) //we gaan een springtest uitvoeren, gebruik makend van Junit
@SpringBootTest(classes = Oak3evaluationformApplication.class) //zorgt ervoor dat de annotatie gestart wordt
@ActiveProfiles("miel")


public class EvaluationServiceTest {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private StudentService studentService;


    private Evaluation testEvaluation;
    private List<Evaluation> testList;
    private Course testCourse;
    private Instructor testInstructor;
    private Student testStudent;

    @Before
    public void init() {
        testCourse = courseService.findOne(1);
        testInstructor = instructorService.findOne(1);
        testStudent = studentService.findOne(1);
        testEvaluation = new Evaluation();
        testEvaluation.setDate(Date.valueOf("2017-11-21"));
        testEvaluation.setComments("TestComments");
        testEvaluation.setCourse(testCourse);
        testEvaluation.setInstructor(testInstructor);
        testEvaluation.setStudent(testStudent);

    }

//    @After
//    public void clean() {
//        if (!evaluationService.findAll().isEmpty()) {
//                evaluationService.deleteEvaluation(testEvaluation);
//            }
//    }

    @Test
    public void addEvaluation(){
        int newEvaluation = evaluationService.addEvaluation(testEvaluation);
        assertThat(newEvaluation).isEqualTo(1);
    }


    @Test
    public void updateEvaluation() {
      evaluationService.addEvaluation(testEvaluation);
      Evaluation updatedEvaluation = evaluationService.findAll().get(evaluationService.findAll().size()-1);
      updatedEvaluation.setComments("Gewijzigd");
      int updated = evaluationService.updateEvaluation(updatedEvaluation);
      assertThat(updated).isEqualTo(1);
    }
//
    @Test
    public void deleteEvaluation() {
        evaluationService.addEvaluation(testEvaluation);
        int i = evaluationService.deleteEvaluation(evaluationService.findAll().get(evaluationService.findAll().size()-1));
        assertThat(i).isEqualTo(1);

    }

    @Test
    public void findAll() {
        testList = evaluationService.findAll();
        assertThat(testList).isNotNull();
    }

}