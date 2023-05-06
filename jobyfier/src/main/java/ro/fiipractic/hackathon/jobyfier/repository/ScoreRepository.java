package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Score;
import ro.fiipractic.hackathon.jobyfier.model.User;

import java.util.List;
import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, UUID> {
    Score findByUserAndChallenge(User user, Challenge challenge);

    List<Score> getAllByUserId(UUID userId);
}
