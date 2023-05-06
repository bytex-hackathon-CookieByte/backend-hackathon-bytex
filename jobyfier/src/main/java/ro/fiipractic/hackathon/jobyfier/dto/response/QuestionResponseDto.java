package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class QuestionResponseDto {
    private UUID id;
    private String text;
    private int points;
    private UUID stageId;

    public QuestionResponseDto(UUID id, String text, int points, UUID stageId) {
        this.id = id;
        this.text = text;
        this.points = points;
        this.stageId = stageId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
