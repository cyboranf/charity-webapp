package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.charity.domain.ChangeToken;

public interface ChangeTokenRepository extends JpaRepository<ChangeToken, Long> {
    ChangeToken findFirstByToken(String token);
}
