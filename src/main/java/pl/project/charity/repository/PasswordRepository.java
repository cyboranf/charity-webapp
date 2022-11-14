package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.charity.models.Password;

public interface PasswordRepository {

    void createResetToken(Password password, String token);

    void update(Password password);
}
