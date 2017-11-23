package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Question;
import java.util.List;

public interface QuestionService {

    int addQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestion(Question question);

    List<Question> findAll();

    Question findOne(int id);
}
