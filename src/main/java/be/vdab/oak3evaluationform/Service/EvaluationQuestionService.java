package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.EvaluationQuestion;

import java.util.List;

public interface EvaluationQuestionService {


    int addEvaluationQuestion(EvaluationQuestion evaluationQuestion);
    int updateEvaluationQuestion(EvaluationQuestion evaluationQuestion);
    int deleteEvaluationQuestion(EvaluationQuestion evaluationQuestion);

    List<EvaluationQuestion> findAll();

    EvaluationQuestion findOne(int id);
}
