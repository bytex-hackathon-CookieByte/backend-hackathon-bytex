package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.request.ExperienceRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.UserRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.ExperienceResponseDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.UserResponseDto;
import ro.fiipractic.hackathon.jobyfier.model.Experience;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequestDto userRequestDto){
        User user = userService.convertDtoToUser(userRequestDto);
        userService.save(user);
        return ResponseEntity.ok("User created successfully");
    }



    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping()
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
        return ResponseEntity.ok("Experience added successfully");
    }

    @GetMapping("/experience")
    public List<ExperienceResponseDto> getAllExperiences(@RequestParam String username){
        User user = userService.getUserByUsername(username);

        List<Experience> experiences = userService.findAllExperiences(user);

        return userService.convertExperiencesToDto(experiences);
    }
}
