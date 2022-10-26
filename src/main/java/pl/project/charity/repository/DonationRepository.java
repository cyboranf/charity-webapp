package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.charity.domain.Donation;




public interface DonationRepository extends JpaRepository<Donation, Long> {

}
