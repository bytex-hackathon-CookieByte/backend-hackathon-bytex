package ro.fiipractic.hackathon.jobyfier.model.userCourse;

import jakarta.persistence.*;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.model.User;

@Entity
@Table(name = "user_courses")
public class UserCourseMapping {
    @EmbeddedId
    private UserCourseId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_course_user1",
                    foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE"))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JoinColumn(name = "course_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_course_user2",
                    foreignKeyDefinition = "FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE"))
    private Course course;

    public UserCourseMapping() {
    }

    public UserCourseMapping(UserCourseId id, User user, Course course) {
        this.id = id;
        this.user = user;
        this.course = course;
    }

    public UserCourseId getId() {
        return id;
    }

    public void setId(UserCourseId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
