    package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Subtopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @NotNull
    private int topicId;
    @NotNull
    private String name;

    public Subtopic() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
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
                ", topicId=" + topicId +
                ", name='" + name + '\'' +
                '}';
    }
}
