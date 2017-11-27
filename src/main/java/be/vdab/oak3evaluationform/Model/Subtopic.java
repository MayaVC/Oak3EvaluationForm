    package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

    @Entity
public class Subtopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @NotNull
    private String name;
    @ManyToMany(mappedBy = "subtopics")


    private Set<Student> students;

    public Subtopic() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subtopic{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
