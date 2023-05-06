package ro.fiipractic.hackathon.jobyfier.model.question;

import jakarta.persistence.Entity;
import ro.fiipractic.hackathon.jobyfier.model.Stage;

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
