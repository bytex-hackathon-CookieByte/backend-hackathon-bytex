package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class StageRequestDto {

    @NotNull
    private UUID challengeId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private int duration;

    public StageRequestDto(UUID challengeId, String title, String description, int duration) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public UUID getChallengeId() {
        return challengeId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
}
