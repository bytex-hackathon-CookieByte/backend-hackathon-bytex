package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.model.Score;
import ro.fiipractic.hackathon.jobyfier.model.User;

import java.util.List;
import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, UUID> {
    Score findByUserAndChallenge(User user, Challenge challenge);

    List<Score> getAllByUserId(UUID userId);


    @Modifying
    @Query("UPDATE Score s SET s.scoreValue = :scoreValue WHERE s.user.id = :userId AND s.challenge.id = :challengeId")
    void updateScore(@Param("userId")UUID id, @Param("challengeId")UUID id1, @Param("scoreValue")int scoreValue);

    List<Score> findAllByUserIdAndScoreValueLessThan(UUID id, int i);
}
