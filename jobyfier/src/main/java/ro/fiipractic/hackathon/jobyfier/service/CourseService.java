package ro.fiipractic.hackathon.jobyfier.service;


import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.CourseRequestDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.exception.NotFoundException;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.repository.CourseRepository;

@Service
public class CourseService  {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public Course saveCourse(Course course){
        if(courseRepository.findByTitle(course.getTitle())!=null){
            throw new BadRequestException("Course with title " + course.getTitle() + " already exists!");
        }
        return courseRepository.save(course);
    }
    public Course convertDtoToCourse(CourseRequestDto courseRequestDto) {
        return new Course(courseRequestDto.getTitle(),
                courseRequestDto.getPrice(),
                courseRequestDto.getContent(),
                courseRequestDto.getCompany()
                );
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
}

