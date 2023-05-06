package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.ChallengeRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.request.StageRequestDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.ChallengeResponseDto;
import ro.fiipractic.hackathon.jobyfier.dto.response.StageResponseDto;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.exception.NotFoundException;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Stage;
import ro.fiipractic.hackathon.jobyfier.repository.ChallengeRepository;
import ro.fiipractic.hackathon.jobyfier.repository.StageRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ChallengeService {

    final private ChallengeRepository challengeRepository;
    final private StageRepository stageRepository;


    public ChallengeService(ChallengeRepository challengeRepository, StageRepository stageRepository) {
        this.challengeRepository = challengeRepository;
        this.stageRepository = stageRepository;
    }


    public Challenge convertDtoToChallenge(ChallengeRequestDto challengeRequestDto) {
        Instant startTime = Instant.parse(challengeRequestDto.getStartTime());

        return new Challenge(challengeRequestDto.getTitle(),
                challengeRequestDto.getDescription(),
                challengeRequestDto.getPrice(),
                challengeRequestDto.getAdPrice(),
                startTime.toEpochMilli(),
                null, null);
    }

    public void saveChallenge(Challenge challenge) {
        challengeRepository.save(challenge);
    }

    public Challenge getChallengeById(UUID challengeId) {

        if(!challengeRepository.existsById(challengeId)) {
            throw new BadRequestException("Challenge not found");
        }

        return challengeRepository.findById(challengeId).orElse(null);
    }

    public Stage convertDtoToStage(StageRequestDto stageRequestDto) {
        return new Stage(
                stageRequestDto.getTitle(),
                stageRequestDto.getDescription(),
                stageRequestDto.getDuration(),
                null
        );
    }


    public List<StageResponseDto> convertStageToDto(List<Stage> stages) {
        return stages.stream().
                map(stage -> new StageResponseDto(
                        stage.getId(),
                        stage.getTitle(),
                        stage.getDescription(),
                        stage.getDuration(),
                        stage.getChallenge().getId()
                )).toList();
    }

    public List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }

    public List<ChallengeResponseDto> convertChallengeToDto(List<Challenge> challenges) {
        return challenges.stream().
                map(challenge -> new ChallengeResponseDto(
                        challenge.getId(),
                        challenge.getTitle(),
                        challenge.getDescription(),
                        challenge.getPrice(),
                        challenge.getAdPrice(),
                        challenge.getStartTime(),
                        challenge.getCompany().getId()
                )).toList();
    }


    public List<Stage> getStagesByChallengeId(UUID challengeId) {
        return stageRepository.findAllByChallengeId(challengeId);
    }

    public void addStageToChallenge(Challenge challenge, Stage stage) {
        stage.setChallenge(challenge);
        stageRepository.save(stage);
    }
    public Challenge getChallengeByTitle(String title) {
        return challengeRepository.getByTitle(title);
    }

    public Stage findStageById(UUID stageId) {
        if(stageRepository.findById(stageId)==null){
            throw new NotFoundException("The stage with id " + stageId + " doesn't exist");
        }
        return stageRepository.findById(stageId).orElse(null);
    }

    public void deleteChallenge(Challenge challenge) {
        challengeRepository.delete(challenge);
    }
}
