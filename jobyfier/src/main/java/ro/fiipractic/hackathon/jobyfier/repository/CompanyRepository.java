package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fiipractic.hackathon.jobyfier.model.Company;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Company findByUsername(String username);

    @Modifying
    @Query("UPDATE Company c SET c.tokens = :tokens WHERE c.id = :companyId")
    void updateTokens(@Param("companyId")UUID id, @Param("tokens")int tokens);
}
