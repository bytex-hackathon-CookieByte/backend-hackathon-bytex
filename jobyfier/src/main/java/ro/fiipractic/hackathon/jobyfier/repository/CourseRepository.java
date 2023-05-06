package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.hackathon.jobyfier.model.Course;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    Course findByTitle(String title);

}
