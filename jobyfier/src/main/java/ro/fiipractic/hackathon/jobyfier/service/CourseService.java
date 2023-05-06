package ro.fiipractic.hackathon.jobyfier.service;


import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.CourseRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.CourseResponseDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.exception.NotFoundException;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.repository.CourseRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService  {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public void saveCourse(Course course){
        if(courseRepository.findByTitle(course.getTitle())!=null){
            throw new BadRequestException("Course with title " + course.getTitle() + " already exists!");
        }
         courseRepository.save(course);
    }
    public Course convertDtoToCourse(CourseRequestDto courseRequestDto) {
        return new Course(courseRequestDto.getTitle(),
                courseRequestDto.getPrice(),
                courseRequestDto.getPrize(),
                courseRequestDto.getContent(),
                null
                );
    }

    public List<CourseResponseDto> convertCourseToDto(List<Course> courses) {
        return courses.stream().
                map(course -> new CourseResponseDto(
                        course.getId(),
                        course.getTitle(),
                        course.getPrice(),
                        course.getPrize(),
                        course.getContent(),
                        course.getCompany().getId()
                )).toList();
    }
    public Course getById(UUID id){
        if(courseRepository.findById(id).isEmpty()){
            throw new BadRequestException("The course with id " + id + " doesn't exist");
        }
        return courseRepository.findById(id).orElse(null);
    }

    public Course getByTitle(String title) {
        Course course = courseRepository.findByTitle(title);
        if(course == null)
            throw new NotFoundException("Course with title '" + title + "' was not found.");
        return course;
    }
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    public void save(Course course) {
        courseRepository.save(course);
    }
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}

