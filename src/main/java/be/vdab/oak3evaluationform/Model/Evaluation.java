package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;

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
//    @NotNull
//    private int student_id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

//    @OneToMany(mappedBy ="evaluation", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private Set<EvaluationQuestion> evaluationQuestions = new TreeSet<>();



    public Evaluation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

//    public Set<EvaluationQuestion> getEvaluationQuestions() {
//        return evaluationQuestions;
//    }
//
//    public void setEvaluationQuestions(Set<EvaluationQuestion> evaluationQuestions) {
//        this.evaluationQuestions = evaluationQuestions;
//    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", date=" + date +
                ", comments='" + comments + '\'' +
                ", course=" + course +
                ", instructor=" + instructor +
                ", student=" + student +
//                ", evaluationQuestions=" + evaluationQuestions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evaluation)) return false;

        Evaluation that = (Evaluation) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
