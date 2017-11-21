package be.vdab.oak3evaluationform.Controller;


import be.vdab.oak3evaluationform.Model.Instructor;
import be.vdab.oak3evaluationform.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public int addInstructor(@RequestBody Instructor instructor){
        return instructorService.addInstructor(instructor);
    }

}
