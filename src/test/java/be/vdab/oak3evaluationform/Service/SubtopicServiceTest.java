package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Subtopic;
import be.vdab.oak3evaluationform.Oak3evaluationformApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) //we gaan een springtest uitvoeren, gebruik makend van Junit
@SpringBootTest(classes = Oak3evaluationformApplication.class) //zorgt ervoor dat de annotatie gestart wordt
@ActiveProfiles("miel")

public class SubtopicServiceTest {

    @Autowired
    private SubtopicService subTopicService;

    private Subtopic testSubTopic;
    private List<Subtopic> testList;

    @Before
    public void init() {
        testSubTopic = new Subtopic();
        testSubTopic.setName("TestSubTopic");
    }

//    @After
//    public void clean() {
//        if (!subTopicService.findAll().isEmpty()) {
//            subTopicService.deleteSubtopic(testSubTopic);
//        }
//    }

    @Test
    public void addTopic() {
        int newSubTopic = subTopicService.addSubtopic(testSubTopic);
        assertThat(newSubTopic).isEqualTo(1);
    }

    @Test
    public void updateTopic() {
        subTopicService.addSubtopic(testSubTopic);
        Subtopic updatedSubTopic = subTopicService.findAll().get(subTopicService.findAll().size()-1);
        updatedSubTopic.setName("Gewijzigd");
        int updated = subTopicService.updateSubtopic(updatedSubTopic);
        assertThat(updated).isEqualTo(1);
    }

    @Test
    public void deleteTopic() {
        subTopicService.addSubtopic(testSubTopic);
        int i = subTopicService.deleteSubtopic(subTopicService.findAll().get(subTopicService.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void findAll() {
        testList = subTopicService.findAll();
        assertThat(testList).isNotNull();
    }

}