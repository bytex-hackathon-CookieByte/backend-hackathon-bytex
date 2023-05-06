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


}
