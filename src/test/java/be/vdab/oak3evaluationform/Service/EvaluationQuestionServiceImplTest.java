package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.*;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Oak3evaluationformApplication.class)
@ActiveProfiles("maya")
public class EvaluationQuestionServiceImplTest {

    private EvaluationQuestion testEvaluationQuestion;
    private Question testQuestion;
    private Evaluation testEvaluation;
    private List<EvaluationQuestion> evaluationQuestions;

    @Autowired
    private EvaluationQuestionService evaluationQuestionService;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private QuestionService questionService;


    @Before
    public void init() {
        testQuestion = questionService.findOne(7);
        testEvaluation = evaluationService.findOne(2);
        testEvaluationQuestion = new EvaluationQuestion();
        testEvaluationQuestion.setScore(Score.AVERAGE);
        testEvaluationQuestion.setEvaluation(testEvaluation);
        testEvaluationQuestion.setQuestion(testQuestion);
//
    }

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
        int i = evaluationQuestionService.addEvaluationQuestion(testEvaluationQuestion);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testUpdateEvaluationQuestion() {
        evaluationQuestionService.addEvaluationQuestion(testEvaluationQuestion);
        EvaluationQuestion updatedEvaluationQuestion = evaluationQuestionService.findAll().get(evaluationQuestionService.findAll().size()-1);
        updatedEvaluationQuestion.setScore(Score.GOOD);
        int i = evaluationQuestionService.updateEvaluationQuestion(updatedEvaluationQuestion);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testDeleteEvaluationQuestion() {
        evaluationQuestionService.addEvaluationQuestion(testEvaluationQuestion);
        int i = evaluationQuestionService.deleteEvaluationQuestion(evaluationQuestionService.findAll().get(evaluationQuestionService.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testFindAll() {
        evaluationQuestions = evaluationQuestionService.findAll();
        assertThat(evaluationQuestions).isNotNull();
    }

}