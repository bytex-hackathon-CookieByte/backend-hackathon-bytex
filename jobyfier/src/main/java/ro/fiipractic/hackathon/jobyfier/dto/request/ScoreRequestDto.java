package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ScoreRequestDto {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID challengeId;

    public ScoreRequestDto(UUID userId, UUID challengeId) {
        this.userId = userId;
        this.challengeId = challengeId;
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
}
