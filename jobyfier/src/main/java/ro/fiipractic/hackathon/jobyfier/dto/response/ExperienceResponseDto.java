package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class ExperienceResponseDto {
    private UUID id;

    private String position;

    private long startTime;
    private long endTime;
    private String description;
    private String type;

    public ExperienceResponseDto(UUID id, String position, long startTime, long endTime, String description, String type) {
        this.id = id;
        this.position = position;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
