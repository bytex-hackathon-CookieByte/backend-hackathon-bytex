package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class StageResponseDto {
    private UUID id;

    private String title;

    private String description;

    private long duration;

    private UUID challengeId;

    public StageResponseDto(UUID id, String title, String description, long duration, UUID challengeId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.challengeId = challengeId;
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

    public UUID getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(UUID challengeId) {
        this.challengeId = challengeId;
    }
}
