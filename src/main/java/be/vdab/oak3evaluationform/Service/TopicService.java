package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Subtopic;
import be.vdab.oak3evaluationform.Model.Topic;

import java.util.List;

public interface TopicService {

    int addTopic(Topic topic);
    int updateTopic(Topic topic);
    int deleteTopic(Topic opic);

    List<Topic> findAll();
}
