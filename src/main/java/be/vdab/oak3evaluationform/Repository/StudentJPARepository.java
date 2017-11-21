package be.vdab.oak3evaluationform.Repository;

import be.vdab.oak3evaluationform.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepository extends JpaRepository<Student,Integer>{


}
