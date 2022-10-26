package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.Donation;
import pl.project.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }
}
