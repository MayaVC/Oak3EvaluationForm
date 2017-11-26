package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "instructors")
    private Set<Course> courses;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Evaluation> evaluations = new TreeSet<>();

    public Instructor() {
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
//                ", evaluations=" + evaluations +
                '}';
    }
}
