package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Evaluation;
import be.vdab.oak3evaluationform.Oak3evaluationformApplication;
import org.junit.After;
import org.junit.Before;
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
@ActiveProfiles("maya")


public class EvaluationServiceTest {

    @Autowired
    private EvaluationService evaluationService;

    private Evaluation testEvaluation;
    private List<Evaluation> testList;

    @Before
    public void init() {
        testEvaluation = new Evaluation();
        testEvaluation.setStudentId(1);
        testEvaluation.setDate(Date.valueOf("2017-11-21"));
        testEvaluation.setInstructorId(1);
        testEvaluation.setCourseId(1);
        testEvaluation.setComments("TestComments");
    }

    @After
    public void clean() {
        if (!evaluationService.findAll().isEmpty()) {
                evaluationService.deleteEvaluation(testEvaluation);
            }
    }

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