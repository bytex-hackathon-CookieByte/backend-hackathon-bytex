package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.request.CourseRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.CourseResponseDto;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;
import ro.fiipractic.hackathon.jobyfier.service.CourseService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;

    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }
    @PostMapping()
    public ResponseEntity<String> registerCourse(@Valid @RequestBody CourseRequestDto courseRequestDto){
        Course course = courseService.convertDtoToCourse(courseRequestDto);
        course.setCompany(companyService.getCompanyById(courseRequestDto.getCompanyId()));
        System.out.println(course.getId());
        courseService.save(course);
        return ResponseEntity.ok(course.getId().toString());
    }
    @GetMapping()
    public List<CourseResponseDto>  getAllCourses(){
        List<Course> courses = courseService.findAll();
        return courseService.convertCourseToDto(courses);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCourse(@Valid @RequestParam UUID courseId){
        Course course = courseService.getById(courseId);
        courseService.deleteCourse(course);
        return ResponseEntity.ok("'" + course.getTitle() + "' successfully deleted!");
    }
}
