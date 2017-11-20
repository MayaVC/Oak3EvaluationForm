package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Instructor;
import be.vdab.oak3evaluationform.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public int addInstructor(Instructor instructor) {
        return 0;
    }
}
