package ro.fiipractic.hackathon.jobyfier.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Score;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.repository.ScoreRepository;

import java.util.List;
import java.util.UUID;
@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }
    public void save(User user, Challenge challenge, int scoreValue) {
        UUID userId = user.getId();
        UUID challengeId = challenge.getId();
        if(scoreRepository.findByUserAndChallenge(user,challenge)!=null)
            throw new BadRequestException("User already took the challenge!");
        Score score = new Score(user,challenge,scoreValue);
        scoreRepository.save(score);
    }

    public List<Score> getAllByUserId(UUID userId) {
        return scoreRepository.getAllByUserId(userId);
    }
//    @Transactional
//    public void updateScore(User user, Challenge challenge, int scoreValue) {
//        scoreRepository.updateScore(user.getId(),challenge.getId(),scoreValue);
//    }

}
