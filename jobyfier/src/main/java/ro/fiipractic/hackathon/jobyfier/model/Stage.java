package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String title;

    private String description;

    private long duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_stage_challenge",
                    foreignKeyDefinition = "FOREIGN KEY (challenge_id) REFERENCES challenges(id) ON DELETE CASCADE"))
    private Challenge challenge;

    public Stage() {
    }

    public Stage( String title, String description, long duration, Challenge challenge) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.challenge = challenge;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
