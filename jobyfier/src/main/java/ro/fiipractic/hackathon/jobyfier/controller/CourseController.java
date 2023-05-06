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

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;

    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerCourse(@Valid @RequestBody CourseRequestDto courseRequestDto){
        Course course = courseService.convertDtoToCourse(courseRequestDto);
        course.setCompany(companyService.getCompanyById(courseRequestDto.getCompanyId()));
        System.out.println(course.getId());
        courseService.save(course);
        return ResponseEntity.ok(course.getId().toString());
    }
    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseService.findAll();
    }
    @GetMapping()
    public CourseResponseDto getUserByTitle(@RequestParam String title){
        Course course = courseService.getByTitle(title);
        return courseService.convertCourseToDto(course);
    }

}
