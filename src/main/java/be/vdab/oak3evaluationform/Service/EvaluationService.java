package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Evaluation;
import be.vdab.oak3evaluationform.Model.Topic;

import java.util.List;

public interface EvaluationService {

    int addEvaluation(Evaluation evaluation);
    int updateEvaluation(Evaluation evaluation);
    int deleteEvaluation(Evaluation evaluation);

    List<Evaluation> findAll();
}
