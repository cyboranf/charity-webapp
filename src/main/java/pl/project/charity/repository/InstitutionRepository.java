package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.charity.domain.Institution;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    void deleteAllById(Iterable<? extends Long> institutions);

    List<Institution> findAll();

    Optional<Institution> findById(Long id);

    Institution save(Institution institution);


}
