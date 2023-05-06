package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.hackathon.jobyfier.model.userCourse.UserCourseId;
import ro.fiipractic.hackathon.jobyfier.model.userCourse.UserCourseMapping;

public interface UserCourseRepository extends JpaRepository<UserCourseMapping, UserCourseId> {
}
