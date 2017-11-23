package be.vdab.oak3evaluationform;

import be.vdab.oak3evaluationform.Model.Course;
import be.vdab.oak3evaluationform.Model.Student;
import be.vdab.oak3evaluationform.Repository.StudentJPARepository;
import be.vdab.oak3evaluationform.Service.StudentService;
import be.vdab.oak3evaluationform.Service.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Oak3evaluationformApplication {


	public static void main(String[] args) {
		SpringApplication.run(Oak3evaluationformApplication.class, args);
	}
}
