package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class QuestionOpenResponseDto extends QuestionResponseDto{

    private String answer;

    public QuestionOpenResponseDto(UUID id, String text, int points, UUID stageId, String answer) {
        super(id, text, points, stageId);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
