package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.ExperienceRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.UserRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.ExperienceResponseDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.UserResponseDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.exception.NotFoundException;
import ro.fiipractic.hackathon.jobyfier.model.Experience;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.repository.CompanyRepository;
import ro.fiipractic.hackathon.jobyfier.repository.ExperienceRepository;
import ro.fiipractic.hackathon.jobyfier.repository.UserCourseRepository;
import ro.fiipractic.hackathon.jobyfier.repository.UserRepository;
import ro.fiipractic.hackathon.jobyfier.util.IPasswordEncoder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    private final IPasswordEncoder passwordEncoder;
    private final ExperienceRepository experienceRepository;
    private final UserCourseRepository userCourseRepository;

    public UserService(UserRepository userRepository,
                       ExperienceRepository experienceRepository,
                       CompanyRepository companyRepository,
                       IPasswordEncoder passwordEncoder,  UserCourseRepository userCourseRepository) {
        this.userRepository = userRepository;
        this.experienceRepository = experienceRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
        this.userCourseRepository = userCourseRepository;
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
    public User getById(UUID id){
        if(userRepository.findById(id).isEmpty()){
            throw new BadRequestException("The user with id " + id + " doesn't exist");
        }
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        if(userRepository.findByUsername(username)==null)
            throw new NotFoundException("User not found!");
        return userRepository.findByUsername(username);
    }

    public UserResponseDto convertUserToDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPhone(),
                user.getTokens());
    }

    public Experience convertDtoToExperience(ExperienceRequestDto experienceRequestDto) {

        Instant startDate = Instant.parse(experienceRequestDto.getStartDate());
        Instant endDate = Instant.parse(experienceRequestDto.getEndDate());

        return new Experience(null,
                experienceRequestDto.getPosition(),
                startDate.toEpochMilli(),
                endDate.toEpochMilli(),
                experienceRequestDto.getDescription(),
                experienceRequestDto.getType());
    }

    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    public List<Experience> findAllExperiences(User user) {
        return experienceRepository.findAllByUserId(user.getId());
    }

    public List<ExperienceResponseDto> convertExperiencesToDto(List<Experience> experiences) {
        return experiences.stream().map(experience -> new ExperienceResponseDto(
                experience.getId(),
                experience.getPosition(),
                experience.getStartTime(),
                experience.getEndTime(),
                experience.getDescription(),
                experience.getType())).toList();
    }



    public ResponseEntity<Object> login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadRequestException("Invalid password!");
        }
        return ResponseEntity.ok(convertUserToDto(user));
    }
}
