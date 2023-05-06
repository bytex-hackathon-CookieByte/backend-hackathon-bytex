package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ScoreRequestDto {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID challengeId;
    @NotNull
    private int scoreValue;

    public ScoreRequestDto(UUID userId, UUID challengeId, int scoreValue) {
        this.userId = userId;
        this.challengeId = challengeId;
        this.scoreValue = scoreValue;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(UUID challengeId) {
        this.challengeId = challengeId;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }
}
