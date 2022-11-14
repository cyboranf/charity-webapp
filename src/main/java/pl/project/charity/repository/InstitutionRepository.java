package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.charity.domain.Institution;




public interface InstitutionRepository extends JpaRepository<Institution,Long> {
        Institution findFirstById(Long id);


}
