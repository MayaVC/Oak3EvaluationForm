package be.vdab.oak3evaluationform.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int studenId;
    @NotNull
    Date date;
    @NotNull
    int instructorId;
    @NotNull
    int courseId;
    @NotNull
    String comments;

    public Evaluation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudenId() {
        return studenId;
    }

    public void setStudenId(int studenId) {
        this.studenId = studenId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", studenId=" + studenId +
                ", date=" + date +
                ", instructorId=" + instructorId +
                ", courseId=" + courseId +
                ", comments='" + comments + '\'' +
                '}';
    }
}
