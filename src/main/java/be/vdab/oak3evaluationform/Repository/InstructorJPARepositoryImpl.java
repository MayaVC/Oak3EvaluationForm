package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public class InstructorJPARepositoryImpl implements InstructorRepository {

    @Autowired
    private final InstructorJPARepository iJPAR;

    public InstructorJPARepositoryImpl(InstructorJPARepository iJPAR) {
        this.iJPAR = iJPAR;
    }


    @Override
    public int addInstructor(Instructor instructor) {
        Instructor i = iJPAR.saveAndFlush(instructor);
        return i != null ? 1 :0 ;

    }
}
