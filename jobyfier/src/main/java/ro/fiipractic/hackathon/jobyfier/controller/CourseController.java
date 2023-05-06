package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fiipractic.hackathon.jobyfier.dto.request.CourseRequestDto;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerCourse(@Valid @RequestBody CourseRequestDto courseRequestDto){
        Course course = courseService.convertDtoToCourse(courseRequestDto);
        courseService.save(course);
        return ResponseEntity.ok("User created successfully");
    }

}
