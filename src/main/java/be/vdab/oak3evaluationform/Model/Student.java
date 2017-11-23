package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String firstName;

    @NotNull
    private String eMail;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "student_id")
//    private Set<Evaluation> evaluations = new TreeSet<>();

    @ManyToMany
    @JoinTable(name = "student_subtopic", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "subtopic_id", referencedColumnName = "id"))
    private Set<Subtopic> subtopics;


    public Student() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

//    public Set<Evaluation> getEvaluations() {
//        return evaluations;
//    }
//
//    public void setEvaluations(Set<Evaluation> evaluations) {
//        this.evaluations = evaluations;
//    }

    public Set<Subtopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(Set<Subtopic> subtopics) {
        this.subtopics = subtopics;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", eMail='" + eMail + '\'' +
//                ", evaluations=" + evaluations +
                ", subtopics=" + subtopics +
                '}';
    }
}
