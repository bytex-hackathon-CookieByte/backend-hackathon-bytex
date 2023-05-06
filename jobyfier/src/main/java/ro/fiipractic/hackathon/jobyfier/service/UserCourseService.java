package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.model.userCourse.UserCourseId;
import ro.fiipractic.hackathon.jobyfier.model.userCourse.UserCourseMapping;
import ro.fiipractic.hackathon.jobyfier.repository.UserCourseRepository;

@Service
public class UserCourseService {
    private final UserCourseRepository userCourseRepository;


    public UserCourseService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;

    }
    public void saveUserCourse(User user, Course course){
        UserCourseId  userCourseId= new UserCourseId(user.getId(),course.getId());
        if(!userCourseRepository.findById(userCourseId).isEmpty()){
            throw new BadRequestException("The user with id " + user.getId() + " is already enrolled in course with id " + course.getId());
        }
        UserCourseMapping userCourseMapping = new UserCourseMapping(userCourseId,user,course);
        userCourseRepository.save(userCourseMapping);
    }
}
