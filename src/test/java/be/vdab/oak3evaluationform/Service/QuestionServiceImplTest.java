package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Category;
import be.vdab.oak3evaluationform.Model.Question;
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
@ActiveProfiles("miel")
public class QuestionServiceImplTest {

    private List<Question> questions;
    private Question question;

    @Autowired
    private QuestionService questionService;

    @Before
    public void init() {
        question = new Question();
        question.setName("Test Question");
        question.setCategory(Category.GENERAL);
    }

    @After
    public void clean(){
        if(!questionService.findAll().isEmpty()){
            for(Question q : questionService.findAll()){
                questionService.deleteQuestion(q);
            }
        }
    }

    @Test
    public void testAddQuestion() {
        int i = questionService.addQuestion(question);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testUpdateQuestion() {
        questionService.addQuestion(question);
        Question updatedQuestion = questionService.findAll().get(questionService.findAll().size()-1);
        updatedQuestion.setName("Test Question Updated");
        int i = questionService.updateQuestion(updatedQuestion);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testDeleteQuestion() {
        questionService.addQuestion(question);
        int i = questionService.deleteQuestion(questionService.findAll().get(questionService.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testFindAll()  {
        questions = questionService.findAll();
        assertThat(questions).isNotNull();
    }

}