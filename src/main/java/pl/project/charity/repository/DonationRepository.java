package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.charity.domain.Donation;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    void deleteAllById(Iterable<? extends Long> donations);

    @Override
    List<Donation> findAll();

    @Override
    Optional<Donation> findById(Long id);

    Donation save(Donation donation);
}
