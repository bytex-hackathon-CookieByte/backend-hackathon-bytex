package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class QuestionOpenRequestDto extends QuestionRequestDto{
    @NotBlank
    private String answer;
    public QuestionOpenRequestDto(String text, int points, UUID stageId, String answer) {
        super(text, points, stageId);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
