package ro.fiipractic.hackathon.jobyfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fiipractic.hackathon.jobyfier.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.tokens = :tokens WHERE u.id = :userId")
    void updateTokens(@Param("userId")UUID id, @Param("tokens")int tokens);

    @Modifying
    @Query("UPDATE User u SET u.avatar = :avatar WHERE u.id = :userId")
    void updateAvatar(@Param("userId")UUID id, @Param("avatar")String avatar);
}
