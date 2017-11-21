package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.EvaluationQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationQuestionJPARepository extends JpaRepository<EvaluationQuestion,Integer> {
}
