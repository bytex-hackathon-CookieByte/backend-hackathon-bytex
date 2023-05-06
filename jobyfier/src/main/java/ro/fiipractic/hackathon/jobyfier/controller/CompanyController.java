package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fiipractic.hackathon.jobyfier.dto.request.CompanyRequestDto;
import ro.fiipractic.hackathon.jobyfier.model.Company;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerCompany(@Valid @RequestBody CompanyRequestDto companyRequestDto){
        Company company = new Company(companyRequestDto.getUsername(),
                companyRequestDto.getName(),
                companyRequestDto.getPassword(),
                companyRequestDto.getEmail(),
                companyRequestDto.getPhone(),
                companyRequestDto.getTokens()
        );
        companyService.saveCompany(company);
        return ResponseEntity.ok("Company " + company.getUsername() + " has been registered successfully!");
    }
}
