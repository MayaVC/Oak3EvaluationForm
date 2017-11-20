package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private EnumScore score;

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
    public EnumScore getScore() {
        return score;
    }

    public void setScore(EnumScore score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "EvaluationQuestion{" +
                "evaluationId=" + evaluationId +
                ", categoryId=" + categoryId +
                ", questionId=" + questionId +
                ", score=" + score +
                '}';
    }
}
