package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJPARepository extends JpaRepository<Question,Integer> {
}