package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.charity.domain.ChangeToken;
import pl.project.charity.domain.ResetToken;

public interface ResetTokenRepository extends JpaRepository<ResetToken,String> {
    ResetToken findFirstByToken(String token);

}
