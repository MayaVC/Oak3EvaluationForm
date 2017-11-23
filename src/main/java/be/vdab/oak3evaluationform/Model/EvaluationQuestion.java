package be.vdab.oak3evaluationform.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class EvaluationQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @NotNull
//    private int evaluationId;
//    @NotNull
//    private int questionId;
    @NotNull
    private Score score;
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Question question;



    public EvaluationQuestion() {
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

//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }


    @Override
    public String toString() {
        return "EvaluationQuestion{" +
                "id=" + id +
                ", score=" + score +
//                ", question=" + question +
                '}';
    }
}
