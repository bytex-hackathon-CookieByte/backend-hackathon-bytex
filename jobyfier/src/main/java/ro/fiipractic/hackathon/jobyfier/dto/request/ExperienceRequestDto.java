package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ExperienceRequestDto {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Position is required.")
    private String position;

    @NotBlank(message = "Start date is required.")
    private String startDate;

    private String endDate;

    private String description;

    @NotBlank
    private String type;

    public ExperienceRequestDto(String username, String position, String startDate, String endDate, String description, String type) {
        this.username = username;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getPosition() {
        return position;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
