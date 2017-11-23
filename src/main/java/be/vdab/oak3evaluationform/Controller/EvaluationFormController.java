package be.vdab.oak3evaluationform.Controller;

import be.vdab.oak3evaluationform.Model.Instructor;
import be.vdab.oak3evaluationform.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Om er een webapplicatie te kunnen van maken. Werkt met JSON.
@RequestMapping("/evaluationForm")
public class EvaluationFormController {

    private final InstructorService instructorService;

    @Autowired
    public EvaluationFormController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @PostMapping
    public ResponseEntity addInstructor(@RequestBody Instructor instructor){
        return ResponseEntity.ok(instructorService.addInstructor(instructor));
    }

    @GetMapping("/instructors")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(instructorService.findAll());
    }


}
