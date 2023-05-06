package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.exception.BadRequestException;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Score;
import ro.fiipractic.hackathon.jobyfier.model.User;
import ro.fiipractic.hackathon.jobyfier.repository.ScoreRepository;

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
}
