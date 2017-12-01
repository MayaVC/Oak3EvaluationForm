package be.vdab.oak3evaluationform.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "instructors")
    @JsonBackReference
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructor)) return false;

        Instructor that = (Instructor) o;

        if (getId() != that.getId()) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
