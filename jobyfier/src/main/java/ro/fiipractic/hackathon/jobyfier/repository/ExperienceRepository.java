package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.hackathon.jobyfier.model.Experience;

import java.util.List;
import java.util.UUID;

public interface ExperienceRepository extends JpaRepository<Experience, UUID> {

    List<Experience> findAllByUserId(UUID id);
}
