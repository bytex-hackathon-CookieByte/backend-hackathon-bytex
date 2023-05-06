package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.request.CompanyRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.CompanyResponseDto;
import ro.fiipractic.hackathon.jobyfier.model.Company;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping()
    public ResponseEntity<String> registerCompany(@Valid @RequestBody CompanyRequestDto companyRequestDto){
        Company company = companyService.convertDtoToCompany(companyRequestDto);
        companyService.saveCompany(company);
        return ResponseEntity.ok(company.getId().toString());
    }
    @GetMapping()
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/search")
    public CompanyResponseDto getUserByUsername(@RequestParam String username){
        Company company = companyService.getCompanyByUsername(username);
        return companyService.convertCompanyToDto(company);
    }
}
