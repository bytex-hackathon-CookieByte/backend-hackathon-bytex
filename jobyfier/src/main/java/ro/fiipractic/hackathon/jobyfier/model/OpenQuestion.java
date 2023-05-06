package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class OpenQuestion extends Question {
    private String answer;

    public OpenQuestion() {
    }

    public OpenQuestion(UUID id, String text, int points, String answer) {
        super(id, text, points);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
