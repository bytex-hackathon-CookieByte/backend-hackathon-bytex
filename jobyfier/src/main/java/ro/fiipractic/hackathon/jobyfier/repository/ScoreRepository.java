package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.hackathon.jobyfier.model.Score;

import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, UUID> {
    boolean findByUserAndChallenge(UUID userId,UUID challengeId);
}
