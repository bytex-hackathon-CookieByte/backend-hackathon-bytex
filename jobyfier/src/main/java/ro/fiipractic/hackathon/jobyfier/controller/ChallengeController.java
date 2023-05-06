package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.request.ChallengeRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.StageRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.ChallengeResponseDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.StageResponseDto;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Stage;
import ro.fiipractic.hackathon.jobyfier.service.ChallengeService;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;

import java.util.List;
import java.util.UUID;

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
        challengeService.saveChallenge(challenge);
        return ResponseEntity.ok(challenge.getId().toString());
    }

    @GetMapping("/all")
    public List<ChallengeResponseDto> getChallenges() {
        List<Challenge> challenges = challengeService.getChallenges();
        return challengeService.convertChallengeToDto(challenges);
    }

    @GetMapping()
    public Challenge getChallengeById(@RequestParam UUID id) {
        return challengeService.getChallengeById(id);
    }

    @PostMapping("/stages")
    public ResponseEntity<String> createChallengeStages(@Valid @RequestBody StageRequestDto stageRequestDto) {
        Challenge challenge = challengeService.getChallengeById(stageRequestDto.getChallengeId());
        Stage stage = challengeService.convertDtoToStage(stageRequestDto);
        stage.setChallenge(challenge);
        challengeService.addStageToChallenge(challenge, stage);
        return ResponseEntity.ok(challenge.getId().toString());
    }

    @GetMapping("/stages")
    public List<StageResponseDto> getChallengeStages(@RequestParam UUID challengeId) {
        Challenge challenge = challengeService.getChallengeById(challengeId);
        List<Stage> stages = challengeService.getStagesByChallengeId(challengeId);
        return challengeService.convertStageToDto(stages);
    }
}
