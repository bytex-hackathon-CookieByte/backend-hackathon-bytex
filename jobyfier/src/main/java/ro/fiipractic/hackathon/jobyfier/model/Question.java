package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_question_stage",
                    foreignKeyDefinition = "FOREIGN KEY (stage_id) REFERENCES stages(id) ON DELETE CASCADE"))
    private Stage stage;

    public Question() {
    }

    public Question(String text, int points, Stage stage) {
        this.text = text;
        this.points = points;
        this.stage = stage;
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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
