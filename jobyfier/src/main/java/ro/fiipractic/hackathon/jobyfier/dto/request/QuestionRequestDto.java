package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class QuestionRequestDto {
    @NotBlank
    private String text;
    @NotNull
    private int points;
    @NotNull
    private UUID stageId;

    public QuestionRequestDto(String text, int points, UUID stageId) {
        this.text = text;
        this.points = points;
        this.stageId = stageId;
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

    public UUID getStageId() {
        return stageId;
    }

    public void setStageId(UUID stageId) {
        this.stageId = stageId;
    }
}
