package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Topic;
import be.vdab.oak3evaluationform.Repository.TopicJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicJPARepository topicJPARepository;

    @Autowired
    public TopicServiceImpl(TopicJPARepository topicJPARepository) {
        this.topicJPARepository = topicJPARepository;
    }

    @Override
    public int addTopic(Topic topic) {
        Topic newTopic = topicJPARepository.saveAndFlush(topic);
        return newTopic==null?0:1;
    }

    @Override
    public int updateTopic(Topic topic) {
        Topic updateTopic = null;
        if (topicJPARepository.exists(topic.getId())) {
            updateTopic = topicJPARepository.saveAndFlush(topic);
        }
        return updateTopic==null?0:1;
    }

    @Override
    public int deleteTopic(Topic topic) {
        if (topicJPARepository.exists(topic.getId())) {
            topicJPARepository.delete(topic.getId());
        }
        return topicJPARepository.exists(topic.getId())?0:1;
    }

    @Override
    public List<Topic> findAll() {
        return topicJPARepository.findAll();
    }

    @Override
    public Topic findOne(int id) {return topicJPARepository.findOne(id);}
}
