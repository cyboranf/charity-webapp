package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.charity.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
    User findFirstById(Long userId);

    User findByFirstName(String name);
    void createVerificationToken(User user, String token);

    void confirmUser(String token);

    void createChangeEmailToken(User user, String token);

    void confirmChangeEmail(String token);
}
