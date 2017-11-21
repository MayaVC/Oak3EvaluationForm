package be.vdab.oak3evaluationform.Service;

import be.vdab.oak3evaluationform.Model.Instructor;
import be.vdab.oak3evaluationform.Repository.InstructorJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorJPARepository instructorJPARepository;

    @Autowired
    public InstructorServiceImpl(InstructorJPARepository instructorJPARepository) {
        this.instructorJPARepository = instructorJPARepository;
    }

    @Override
    public int addInstructor(Instructor instructor) {
        Instructor i = instructorJPARepository.saveAndFlush(instructor);
        return i != null ? 1 : 0;
    }

    @Override
    public int deleteInstructor(Instructor instructor) {
        if(instructorJPARepository.exists(instructor.getId())){
        instructorJPARepository.delete(instructor);}
        return instructorJPARepository.exists(instructor.getId())?0:1 ;
    }

    @Override
    public int updateInstructor(Instructor instructor) {
        Instructor updatedInstructor = null;
        if (instructorJPARepository.exists(instructor.getId())) {
            updatedInstructor = instructorJPARepository.saveAndFlush(instructor);
        }
        return updatedInstructor==null ? 0 : 1;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorJPARepository.findAll();
    }
}
