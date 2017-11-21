package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class EvaluationQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private int evaluationId;
    @NotNull
    private int categoryId;
    @NotNull
    private int questionId;
    @NotNull
    private Score score;

    public EvaluationQuestion() {
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

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
                ", evaluationId=" + evaluationId +
                ", categoryId=" + categoryId +
                ", questionId=" + questionId +
                ", score=" + score +
                '}';
    }
}
