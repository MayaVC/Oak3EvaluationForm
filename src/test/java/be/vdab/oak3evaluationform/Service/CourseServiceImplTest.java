package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Course;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Oak3evaluationformApplication.class)
@ActiveProfiles("miel")
public class CourseServiceImplTest {

    private List<Course> courses;
    private Course course;

    @Autowired
    private CourseService service;

    @Before
    public void init(){
        course = new Course();
        course.setName("Java Voor Prutsers");
    }

//    @After
//    public void clear(){
//        if(!service.findAll().isEmpty()) {
//            for (Course c : service.findAll()) {
//                service.deleteCourse(c);
//            }
//        }
//    }

    @Test
    public void testAddCourse(){
        int i = service.addCourse(course);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testDeleteCourse(){
        service.addCourse(course);
        int i = service.deleteCourse(service.findAll().get(service.findAll().size()-1));
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testUpdateCourse(){
        service.addCourse(course);
        Course updatedCourse = service.findAll().get(service.findAll().size() - 1);
        updatedCourse.setName("Java voor noobs");
        int i = service.updateCourse(updatedCourse);
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testFindAll(){
        courses = service.findAll();
        assertThat(courses).isNotNull();
    }

}