package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Question;
import be.vdab.oak3evaluationform.Repository.QuestionJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionJPARepository questionJPARepository;

    @Autowired
    public QuestionServiceImpl(QuestionJPARepository questionJPARepository) {
        this.questionJPARepository = questionJPARepository;
    }

    @Override
    public int addQuestion(Question question) {
        Question q = questionJPARepository.saveAndFlush(question);
        return  q!= null ? 1 : 0;
    }

    @Override
    public int updateQuestion(Question question) {
        Question updatedQuestion = null;
        if(questionJPARepository.exists(question.getId())){
            updatedQuestion = questionJPARepository.saveAndFlush(question);
        }
        return updatedQuestion!= null ? 1:0;
    }


    @Override
    public int deleteQuestion(Question question) {
        if(questionJPARepository.exists(question.getId())){
            questionJPARepository.delete(question);
        }
        return  questionJPARepository.exists(question.getId())? 0 : 1;
    }


    @Override
    public List<Question> findAll() {
        return questionJPARepository.findAll();
    }
}
