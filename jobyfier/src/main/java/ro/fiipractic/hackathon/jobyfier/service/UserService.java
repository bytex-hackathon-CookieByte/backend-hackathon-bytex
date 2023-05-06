package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.UserRequestDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.repository.CompanyRepository;
import ro.fiipractic.hackathon.jobyfier.repository.UserRepository;
import ro.fiipractic.hackathon.jobyfier.util.IPasswordEncoder;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    private IPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository, IPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User convertDtoToUser(UserRequestDto userRequestDto) {
        return new User(userRequestDto.getUsername(),
                userRequestDto.getPassword(),
                userRequestDto.getFirstname(),
                userRequestDto.getLastname(),
                userRequestDto.getEmail(),
                userRequestDto.getPhone(),
                userRequestDto.getTokens());
    }

    public void save(User user) {
        if(userRepository.findByUsername(user.getUsername())!=null)
            throw new BadRequestException("Username taken!");
        if(companyRepository.findByUsername(user.getUsername())!=null)
            throw new BadRequestException("Username taken!");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
