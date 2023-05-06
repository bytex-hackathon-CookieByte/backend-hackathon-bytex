package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.hackathon.jobyfier.model.question.Question;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}
