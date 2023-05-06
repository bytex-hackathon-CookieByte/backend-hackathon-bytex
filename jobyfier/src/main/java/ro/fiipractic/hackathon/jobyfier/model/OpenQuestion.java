package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.Entity;

@Entity
public class OpenQuestion extends Question {
    private String answer;

    public OpenQuestion() {
    }

    public OpenQuestion(String text, int points, Stage stage, String answer) {
        super(text, points, stage);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
