package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Subtopic;
import be.vdab.oak3evaluationform.Repository.SubtopicJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtopicServiceImpl implements SubtopicService {

    private final SubtopicJPARepository subtopicJPARepository;

    @Autowired
    public SubtopicServiceImpl(SubtopicJPARepository subtopicJPARepository) {
        this.subtopicJPARepository = subtopicJPARepository;
    }

    @Override
    public int addSubtopic(Subtopic subtopic) {
        Subtopic newSubtopic = subtopicJPARepository.saveAndFlush(subtopic);
        return newSubtopic==null?0:1;
    }

    @Override
    public int updateSubtopic(Subtopic subtopic) {
        Subtopic updateSubtopic = null;
        if (subtopicJPARepository.exists(subtopic.getId())) {
            updateSubtopic = subtopicJPARepository.saveAndFlush(subtopic);
        }
        return updateSubtopic==null?0:1;
    }

    @Override
    public int deleteSubtopic(Subtopic subtopic) {
        if (subtopicJPARepository.exists(subtopic.getId())) {
            subtopicJPARepository.delete(subtopic.getId());
        }
        return subtopicJPARepository.exists(subtopic.getId())?0:1;
    }

    @Override
    public List<Subtopic> findAll() {
        return subtopicJPARepository.findAll();
    }
}
