package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.charity.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
