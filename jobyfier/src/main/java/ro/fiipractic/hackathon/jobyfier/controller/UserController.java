package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.request.ExperienceRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.ScoreRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.UserCourseRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.UserRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.ExperienceResponseDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.UserResponseDto;
import ro.fiipractic.hackathon.jobyfier.model.*;
import ro.fiipractic.hackathon.jobyfier.service.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserCourseService userCourseService;
    private final CourseService courseService;
    private final ChallengeService challengeService;
    private final ScoreService scoreService;

    public UserController(UserService userService, UserCourseService userCourseService, CourseService courseService, ChallengeService challengeService, ScoreService scoreService) {
        this.userService = userService;
        this.userCourseService = userCourseService;
        this.courseService = courseService;
        this.challengeService = challengeService;
        this.scoreService = scoreService;
    }

    @PostMapping()
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequestDto userRequestDto){
        User user = userService.convertDtoToUser(userRequestDto);
        userService.save(user);
        return ResponseEntity.ok(user.getId().toString());
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/search")
    public UserResponseDto getUserByUsername(@RequestParam String username){
        User user = userService.getUserByUsername(username);
        return userService.convertUserToDto(user);
    }

    @PostMapping("/experience")
    public ResponseEntity<String> addExperience(@Valid @RequestBody ExperienceRequestDto experienceRequestDto){
        User user = userService.getUserByUsername(experienceRequestDto.getUsername());
        Experience experience = userService.convertDtoToExperience(experienceRequestDto);
        experience.setUser(user);
        userService.saveExperience(experience);
        return ResponseEntity.ok(experience.getId().toString());
    }

    @GetMapping("/experience")
    public List<ExperienceResponseDto> getAllExperiences(@RequestParam String username){
        User user = userService.getUserByUsername(username);

        List<Experience> experiences = userService.findAllExperiences(user);

        return userService.convertExperiencesToDto(experiences);
    }
    @PostMapping("/courses")
    public ResponseEntity<String> addCourse(@RequestBody UserCourseRequestDto userCourseRequestDto){
        User user = userService.getById(userCourseRequestDto.getUserId());
        Course course = courseService.getById(userCourseRequestDto.getCourseId());
        userCourseService.saveUserCourse(user,course);
        return ResponseEntity.ok("Course added successfully");
    }
    @PostMapping("/scores")
    public ResponseEntity<String> addScore(@RequestBody ScoreRequestDto scoreRequestDto){
        User user = userService.getById(scoreRequestDto.getUserId());
        Challenge challenge = challengeService.getChallengeById(scoreRequestDto.getChallengeId());
        int scoreValue = scoreRequestDto.getScoreValue();
        scoreService.save(user,challenge,scoreValue);
        return ResponseEntity.ok("Score added successfully");
    }
    @GetMapping("/scores")
    public List<Score> getScoreByUser(@RequestParam UUID userId){
        System.out.println(userId);
        return scoreService.getAllByUserId(userId);
    }

    @PostMapping("/tokens/add")
    public ResponseEntity<String> addToken(@RequestParam String username, @RequestParam int tokens){
        User user = userService.getUserByUsername(username);
        user.setTokens(user.getTokens() + tokens);
        userService.updateTokens(user);
        return ResponseEntity.ok("Tokens added successfully");
    }

    @PostMapping("/tokens/substract")
    public ResponseEntity<String> subtractToken(@RequestParam String username, @RequestParam int tokens){
        User user = userService.getUserByUsername(username);
        user.setTokens(user.getTokens() - tokens);
        userService.updateTokens(user);
        return ResponseEntity.ok("Tokens subtracted successfully");
    }

}
