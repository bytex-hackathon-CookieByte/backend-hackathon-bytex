package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.QuestionFixedRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.QuestionOpenRequestDto;
import ro.fiipractic.hackathon.jobyfier.exception.NotFoundException;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.question.FixedQuestion;
import ro.fiipractic.hackathon.jobyfier.model.question.OpenQuestion;
import ro.fiipractic.hackathon.jobyfier.model.question.Question;
import ro.fiipractic.hackathon.jobyfier.repository.QuestionRepository;
import ro.fiipractic.hackathon.jobyfier.repository.StageRepository;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {
    final private QuestionRepository questionRepository;
    final private StageRepository stageRepository;

    public QuestionService(QuestionRepository questionRepository, StageRepository stageRepository) {
        this.questionRepository = questionRepository;
        this.stageRepository = stageRepository;
    }
    public void save(Question question){
        questionRepository.save(question);
    }
    public OpenQuestion convertDtoToQuestionOpen(QuestionOpenRequestDto questionOpenRequestDto) {

        return new OpenQuestion(questionOpenRequestDto.getText(),
                questionOpenRequestDto.getPoints(),
                null,
                questionOpenRequestDto.getAnswer());
    }
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
    public FixedQuestion convertDtoToQuestionFixed(QuestionFixedRequestDto questionFixedRequestDto) {

        return new FixedQuestion(questionFixedRequestDto.getText(),
                questionFixedRequestDto.getPoints(),
                null,
                questionFixedRequestDto.getQuiz1(),
                questionFixedRequestDto.getQuiz2(),
                questionFixedRequestDto.getQuiz3(),
                questionFixedRequestDto.getQuiz4(),
                questionFixedRequestDto.getCorrectAnswer())
                ;
    }


    public List<Question> getQuestionsByStage(UUID stageId) {

        return questionRepository.findAllByStageId(stageId);
    }
}
