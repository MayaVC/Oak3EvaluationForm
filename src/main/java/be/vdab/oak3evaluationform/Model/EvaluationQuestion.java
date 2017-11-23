package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class EvaluationQuestion {

    @Id
    private int id;
//    @NotNull
//    private int evaluationId;
//    @NotNull
//    private int questionId;
    @NotNull
    private Score score;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Question question;

    public EvaluationQuestion() {
    }

//    public int getEvaluationId() {
//        return evaluationId;
//    }
//
//    public void setEvaluationId(int evaluationId) {
//        this.evaluationId = evaluationId;
//    }

//    public int getQuestionId() {
//        return questionId;
//    }

//    public void setQuestionId(int questionId) {
//        this.questionId = questionId;
//    }

    @Enumerated(EnumType.STRING)
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EvaluationQuestion{" +
                "id=" + id +
//                ", evaluationId=" + evaluationId +
//                ", questionId=" + questionId +
                ", score=" + score +
                '}';
    }
}
