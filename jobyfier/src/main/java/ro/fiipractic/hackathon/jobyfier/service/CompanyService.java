package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.CompanyRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.CompanyResponseDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.model.Company;
import ro.fiipractic.hackathon.jobyfier.repository.CompanyRepository;
import ro.fiipractic.hackathon.jobyfier.repository.UserRepository;
import ro.fiipractic.hackathon.jobyfier.util.IPasswordEncoder;

import java.util.List;
@Service

public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final IPasswordEncoder passwordEncoder;


    public CompanyService(CompanyRepository companyRepository, UserRepository userRepository, IPasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Company convertDtoToCompany(CompanyRequestDto companyRequestDto){
        return new Company(companyRequestDto.getUsername(),
                companyRequestDto.getName(),
                companyRequestDto.getPassword(),
                companyRequestDto.getEmail(),
                companyRequestDto.getPhone(),
                companyRequestDto.getTokens()
        );
    }
    public Company saveCompany(Company company){
        if(companyRepository.findByUsername(company.getUsername())!=null){
            throw new BadRequestException("Username " + company.getUsername() + " taken");
        }
        if(userRepository.findByUsername(company.getUsername())!=null){
            throw new BadRequestException("Username " + company.getUsername() + " taken");
        }
        company.setPassword(passwordEncoder.encode(company.getPassword()));
        return companyRepository.save(company);
    }
    public Company getCompanyByUsername(String username) {
        Company company = companyRepository.findByUsername(username);
        if(company == null)
            throw new BadRequestException("User with username '" + username + "' was not found.");
        return company;
    }
    public void deleteCompany(Company company, String password) {
        if(!passwordEncoder.matches(password, company.getPassword()))
            throw new BadRequestException("Password provided is incorrect.");
        companyRepository.delete(company);
    }
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    public CompanyResponseDto convertCompanyToDto(Company company) {
        return new CompanyResponseDto(
                company.getId(),
                company.getUsername(),
                company.getName(),
                company.getEmail(),
                company.getPhone(),
                company.getTokens());
    }
}
