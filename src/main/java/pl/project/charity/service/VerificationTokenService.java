package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.VerificationToken;
import pl.project.charity.repository.VerificationTokenRepository;

@Service
@Transactional
public class VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;

    public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    public VerificationToken findFirstByToken(String token) {
        return verificationTokenRepository.findFirstByToken(token);
    }
}
