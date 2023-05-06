package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_score_user",
                    foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE"))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_score_challenge",
                    foreignKeyDefinition = "FOREIGN KEY (challenge_id) REFERENCES challenges(id) ON DELETE CASCADE"))
    private Challenge challenge;
    private int scoreValue;

    public Score() {
    }

    public Score(User user, Challenge challenge, int scoreValue) {
        this.user = user;
        this.challenge = challenge;
        this.scoreValue = scoreValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

}
