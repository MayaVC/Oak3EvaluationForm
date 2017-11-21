package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Subtopic;

import java.util.List;

public interface SubtopicService {

    int addSubtopic(Subtopic subtopic);
    int updateSubtopic(Subtopic subtopic);
    int deleteSubtopic(Subtopic subtopic);

    List<Subtopic> findAll();
}
