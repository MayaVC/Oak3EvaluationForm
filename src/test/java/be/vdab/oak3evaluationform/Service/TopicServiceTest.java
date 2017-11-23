package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Evaluation;
import be.vdab.oak3evaluationform.Model.Topic;
import be.vdab.oak3evaluationform.Oak3evaluationformApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class) //we gaan een springtest uitvoeren, gebruik makend van Junit
@SpringBootTest(classes = Oak3evaluationformApplication.class) //zorgt ervoor dat de annotatie gestart wordt
@ActiveProfiles("maya")
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    private Topic testTopic;
    private List<Topic> testList;

    @Before
    public void init() {
        testTopic = new Topic();
        testTopic.setName("TestTopic");
    }

//    @After
//    public void clean() {
//        if (!topicService.findAll().isEmpty()) {
//            topicService.deleteTopic(testTopic);
//        }
//    }

    @Test
    public void addTopic() {
        int newTopic = topicService.addTopic(testTopic);
        assertThat(newTopic).isEqualTo(1);
    }

    @Test
    public void updateTopic() {
        topicService.addTopic(testTopic);
        Topic updatedTopic = topicService.findAll().get(topicService.findAll().size()-1);
        updatedTopic.setName("Gewijzigd");
        int updated = topicService.updateTopic(updatedTopic);
        assertThat(updated).isEqualTo(1);
    }

    @Test
    public void deleteTopic() {
        topicService.addTopic(testTopic);
        int i = topicService.deleteTopic(topicService.findAll().get(topicService.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void findAll() {
        testList = topicService.findAll();
        assertThat(testList).isNotNull();
    }

}