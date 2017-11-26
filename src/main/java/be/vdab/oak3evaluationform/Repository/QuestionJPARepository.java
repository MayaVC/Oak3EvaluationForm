package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Category;
import be.vdab.oak3evaluationform.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionJPARepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(Category category);
}
