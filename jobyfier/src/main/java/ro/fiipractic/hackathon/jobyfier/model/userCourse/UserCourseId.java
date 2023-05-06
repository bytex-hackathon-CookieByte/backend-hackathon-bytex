package ro.fiipractic.hackathon.jobyfier.model.userCourse;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserCourseId implements Serializable {

    private UUID userId;

    private UUID courseId;

    public UserCourseId() {
    }

    public UserCourseId(UUID userId, UUID courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseId cId = (UserCourseId) o;
        return Objects.equals(userId, cId.userId) && Objects.equals(courseId, cId.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }

}
