package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Subtopic;
import be.vdab.oak3evaluationform.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubtopicJPARepository extends JpaRepository<Subtopic, Integer> {

    List<Subtopic> findByTopicId(Topic topic);
}
