package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;

    @ManyToMany()
    @JoinTable(name = "course_instructor", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "instructor_id", referencedColumnName = "id"))
    private Set<Instructor> instructors;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Evaluation> evaluations = new TreeSet<>();

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

//    public Set<Evaluation> getEvaluations() {
//        return evaluations;
//    }
//
//    public void setEvaluations(Set<Evaluation> evaluations) {
//        this.evaluations = evaluations;
//    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructors=" + instructors +
//                ", evaluations=" + evaluations +
                '}';
    }
}
