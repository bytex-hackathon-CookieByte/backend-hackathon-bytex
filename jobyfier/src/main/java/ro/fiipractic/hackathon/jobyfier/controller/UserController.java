package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.UserRequestDto;
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

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.findAll();
    }
}
