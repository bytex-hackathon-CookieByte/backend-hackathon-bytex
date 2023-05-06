package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.Entity;

@Entity
public class FixedQuestion extends Question{
    private String quiz1;
    private String quiz2;
    private String quiz3;
    private String quiz4;

    private int correctAnswer;


    public FixedQuestion() {
    }

    public FixedQuestion(String text, int points, Stage stage, String quiz1, String quiz2, String quiz3, String quiz4, int correctAnswer) {
        super(text, points, stage);
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(String quiz1) {
        this.quiz1 = quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(String quiz2) {
        this.quiz2 = quiz2;
    }

    public String getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(String quiz3) {
        this.quiz3 = quiz3;
    }

    public String getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(String quiz4) {
        this.quiz4 = quiz4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
