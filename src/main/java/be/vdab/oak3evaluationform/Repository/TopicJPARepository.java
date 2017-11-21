package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicJPARepository extends JpaRepository<Topic, Integer> {
}
