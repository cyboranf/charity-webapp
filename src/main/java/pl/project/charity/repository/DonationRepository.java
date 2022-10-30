package pl.project.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import pl.project.charity.domain.Donation;

import java.util.Optional;


public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer quantityOfAllBags();

    @Query("SELECT COUNT(d) FROM Donation d")
    Integer quantityOfAllDonations();
}
