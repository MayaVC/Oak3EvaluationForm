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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

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

    public Set<Student> getStudents() {
            return students;
    }

    public void setStudents(Set<Student> students) {
            this.students = students;
    }

        public Topic getTopic() {
            return topic;
        }

        public void setTopic(Topic topic) {
            this.topic = topic;
        }


        @Override
        public String toString() {
            return "Subtopic{" +
                    "Id=" + Id +
                    ", name='" + name + '\'' +
                    ", students=" + students +
                    ", topic=" + topic +
                    '}';
        }
    }

