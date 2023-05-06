package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.UserRequestDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.repository.CompanyRepository;
import ro.fiipractic.hackathon.jobyfier.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
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
        userRepository.save(user);
    }
}
