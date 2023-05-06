package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String text;
    private int points;

    public Question() {
    }

    public Question(UUID id, String text, int points) {
        this.id = id;
        this.text = text;
        this.points = points;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
