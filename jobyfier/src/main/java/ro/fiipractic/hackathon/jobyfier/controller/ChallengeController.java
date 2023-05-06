package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fiipractic.hackathon.jobyfier.dto.request.ChallengeRequestDto;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.service.ChallengeService;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    final private ChallengeService challengeService;
    final private CompanyService companyService;


    public ChallengeController(ChallengeService challengeService, CompanyService companyService) {
        this.challengeService = challengeService;
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<String> createChallenge(@Valid @RequestBody ChallengeRequestDto challengeRequestDto) {
        Challenge challenge = challengeService.convertDtoToChallenge(challengeRequestDto);
        challenge.setCompany(companyService.getCompanyById(challengeRequestDto.getCompanyId()));
    }
}
