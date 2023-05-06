package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserCourseRequestDto {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID courseId;

    public UserCourseRequestDto(UUID userId, UUID courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getCourseId() {
        return courseId;
    }
}
