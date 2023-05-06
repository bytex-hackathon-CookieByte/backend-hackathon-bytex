package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fiipractic.hackathon.jobyfier.dto.request.LoginRequestDto;
import ro.fiipractic.hackathon.jobyfier.model.Company;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;
import ro.fiipractic.hackathon.jobyfier.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

    final private UserService userService;
    final private CompanyService companyService;

    public LoginController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        int flag = -1;
        try {
            User user = userService.getUserByUsername(loginRequestDto.getUsername());
            flag = 0;
        }
        catch (Exception e) {
            Company company = companyService.getCompanyByUsername(loginRequestDto.getUsername());
            flag = 1;
        }
        if (flag == 0) {
            return userService.login(loginRequestDto.getUsername(),  loginRequestDto.getPassword());
        }
        else {
            return companyService.login(loginRequestDto.getUsername(),  loginRequestDto.getPassword());
        }
    }
}
