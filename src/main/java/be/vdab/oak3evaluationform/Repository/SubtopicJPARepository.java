package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Subtopic;
import be.vdab.oak3evaluationform.Model.Topic;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubtopicJPARepository extends JpaRepository<Subtopic, Integer> {

    @Query(value = "select sub from Subtopic sub where sub.topic_id = :topicid")
    List<Subtopic> findSubtopicByTopicId(@Param("topicid") int topicId);

    List<Subtopic> findSubtopicsByTopicId ();
}
