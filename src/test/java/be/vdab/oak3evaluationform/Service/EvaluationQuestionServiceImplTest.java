package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.EvaluationQuestion;
import be.vdab.oak3evaluationform.Model.Score;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Oak3evaluationformApplication.class)
//@ActiveProfiles("maya")
public class EvaluationQuestionServiceImplTest {

    private EvaluationQuestion evaluationQuestion;
    private List<EvaluationQuestion> evaluationQuestions;

    @Autowired
    private EvaluationQuestionService evaluationQuestionService;

    @Before
    public void init() {
        evaluationQuestion = new EvaluationQuestion();
        //evaluationQuestion.setEvaluationId(10000);
//        evaluationQuestion.setQuestionId(100);
        evaluationQuestion.setScore(Score.AVERAGE);    }

//    @After
//    public void clean(){
//        if(!evaluationQuestionService.findAll().isEmpty()){
//            for(EvaluationQuestion eq : evaluationQuestionService.findAll()){
//                evaluationQuestionService.deleteEvaluationQuestion(eq);
//            }
//        }
//    }

    @Test
    public void testAddEvaluationQuestion() {
        int i = evaluationQuestionService.addEvaluationQuestion(evaluationQuestion);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testUpdateEvaluationQuestion() {
        evaluationQuestionService.addEvaluationQuestion(evaluationQuestion);
        EvaluationQuestion updatedEvaluationQuestion = evaluationQuestionService.findAll().get(evaluationQuestionService.findAll().size()-1);
        updatedEvaluationQuestion.setScore(Score.GOOD);
        int i = evaluationQuestionService.updateEvaluationQuestion(updatedEvaluationQuestion);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testDeleteEvaluationQuestion() {
        evaluationQuestionService.addEvaluationQuestion(evaluationQuestion);
        int i = evaluationQuestionService.deleteEvaluationQuestion(evaluationQuestionService.findAll().get(evaluationQuestionService.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testFindAll() {
        evaluationQuestions = evaluationQuestionService.findAll();
        assertThat(evaluationQuestions).isNotNull();
    }

}