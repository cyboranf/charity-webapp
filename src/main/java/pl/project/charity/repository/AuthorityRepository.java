package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.charity.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findFirstByEmail(String email);
}
