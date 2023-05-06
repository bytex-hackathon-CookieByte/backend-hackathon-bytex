package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.hackathon.jobyfier.dto.request.ChallengeRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.QuestionFixedRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.QuestionOpenRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.StageRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.ChallengeResponseDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.StageResponseDto;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Course;
import ro.fiipractic.hackathon.jobyfier.model.Stage;
import ro.fiipractic.hackathon.jobyfier.model.question.FixedQuestion;
import ro.fiipractic.hackathon.jobyfier.model.question.OpenQuestion;
import ro.fiipractic.hackathon.jobyfier.model.question.Question;
import ro.fiipractic.hackathon.jobyfier.service.ChallengeService;
import ro.fiipractic.hackathon.jobyfier.service.CompanyService;
import ro.fiipractic.hackathon.jobyfier.service.QuestionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    final private ChallengeService challengeService;
    final private CompanyService companyService;
    private QuestionService questionService;


    public ChallengeController(ChallengeService challengeService, CompanyService companyService, QuestionService questionService) {
        this.challengeService = challengeService;
        this.companyService = companyService;
        this.questionService = questionService;
    }

    @PostMapping()
    public ResponseEntity<String> createChallenge(@Valid @RequestBody ChallengeRequestDto challengeRequestDto) {
        Challenge challenge = challengeService.convertDtoToChallenge(challengeRequestDto);
        challenge.setCompany(companyService.getCompanyById(challengeRequestDto.getCompanyId()));
        challengeService.saveChallenge(challenge);
        return ResponseEntity.ok(challenge.getId().toString());
    }

    @GetMapping()
    public List<ChallengeResponseDto> getChallenges() {
        List<Challenge> challenges = challengeService.getChallenges();
        return challengeService.convertChallengeToDto(challenges);
    }

    @GetMapping("/search")
    public Challenge getChallengeById(@RequestParam UUID id) {
        return challengeService.getChallengeById(id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteChallenge(@Valid @RequestParam UUID challengeId){
        Challenge challenge = challengeService.getChallengeById(challengeId);
        challengeService.deleteChallenge(challenge);
        return ResponseEntity.ok("'" + challenge.getTitle() + "' successfully deleted!");
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
    @PostMapping("/stages/questions//open")
    public ResponseEntity<String> addQuestionOpen(@Valid @RequestBody QuestionOpenRequestDto questionOpenRequestDto){
        OpenQuestion openQuestion = questionService.convertDtoToQuestionOpen(questionOpenRequestDto);
        openQuestion.setStage(challengeService.findStageById(questionOpenRequestDto.getStageId()));
        questionService.save(openQuestion);
        return ResponseEntity.ok(openQuestion.getId().toString());
    }
    @PostMapping("/stages/questions/fixed")
    public ResponseEntity<String> addQuestionFixed(@Valid @RequestBody QuestionFixedRequestDto questionFixedRequestDto){
        FixedQuestion fixedQuestion = questionService.convertDtoToQuestionFixed(questionFixedRequestDto);
        fixedQuestion.setStage(challengeService.findStageById(questionFixedRequestDto.getStageId()));
        System.out.println(questionFixedRequestDto.getCorrectAnswer());

        questionService.save(fixedQuestion);
        return ResponseEntity.ok(fixedQuestion.getId().toString());
    }
    @GetMapping("/stages/questions")
    public List<Question> getAllOpen(){
        return questionService.getQuestions();
    }
    @GetMapping("/stages/questions/search")
    public List<Question> getByStage(@RequestParam UUID stageId){
        return questionService.getQuestionsByStage(stageId);
    }
}
