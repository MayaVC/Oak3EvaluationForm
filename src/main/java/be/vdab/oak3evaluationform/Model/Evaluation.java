package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @NotNull
//    private int studentId; wordt als foreingkey aangemaakt door hybernate
    @NotNull
    private Date date;
//    @NotNull
//    private int instructorId; wordt als foreingkey aangemaakt door hybernate
//    @NotNull
//    private int courseId; wordt als foreingkey aangemaakt door hybernate
    @NotNull
    private String comments;

    public Evaluation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studenId) {
//        this.studentId = studenId;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public int getInstructorId() {
//        return instructorId;
//    }
//
//    public void setInstructorId(int instructorId) {
//        this.instructorId = instructorId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }

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
                ", studentId=" + //studentId +
                ", date=" + date +
                ", instructorId=" + //instructorId +
                ", courseId=" + //courseId +
                ", comments='" + comments + '\'' +
                '}';
    }
}
