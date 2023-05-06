package ro.fiipractic.hackathon.jobyfier.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fiipractic.hackathon.jobyfier.dto.request.QuestionFixedRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.QuestionOpenRequestDto;
import ro.fiipractic.hackathon.jobyfier.model.question.FixedQuestion;
import ro.fiipractic.hackathon.jobyfier.model.question.OpenQuestion;
import ro.fiipractic.hackathon.jobyfier.service.ChallengeService;
import ro.fiipractic.hackathon.jobyfier.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private QuestionService questionService;
    private ChallengeService challengeService;

    public QuestionController(QuestionService questionService, ChallengeService challengeService) {
        this.questionService = questionService;
        this.challengeService = challengeService;
    }
    @PostMapping("/open")
    public ResponseEntity<String> addQuestionOpen(@Valid @RequestBody QuestionOpenRequestDto questionOpenRequestDto){
        OpenQuestion openQuestion = questionService.convertDtoToQuestionOpen(questionOpenRequestDto);
        openQuestion.setStage(challengeService.findStageById(questionOpenRequestDto.getStageId()));
        questionService.save(openQuestion);
        return ResponseEntity.ok(openQuestion.getId().toString());
    }
    @PostMapping("/fixed")
    public ResponseEntity<String> addQuestionFixed(@Valid @RequestBody QuestionFixedRequestDto questionFixedRequestDto){
        FixedQuestion fixedQuestion = questionService.convertDtoToQuestionFixed(questionFixedRequestDto);
        fixedQuestion.setStage(challengeService.findStageById(questionFixedRequestDto.getStageId()));
        System.out.println(questionFixedRequestDto.getCorrectAnswer());

        questionService.save(fixedQuestion);
        return ResponseEntity.ok(fixedQuestion.getId().toString());
    }
}
