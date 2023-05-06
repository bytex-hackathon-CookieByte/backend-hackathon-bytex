package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.repository.CompanyRepository;
import ro.fiipractic.hackathon.jobyfier.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
