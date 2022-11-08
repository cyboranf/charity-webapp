package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.ResetToken;
import pl.project.charity.repository.ResetTokenRepository;

@Service
@Transactional
public class ResetTokenService {
    private final ResetTokenRepository resetTokenRepository;

    public ResetTokenService(ResetTokenRepository resetTokenRepository) {
        this.resetTokenRepository = resetTokenRepository;
    }

    public ResetToken findFirstByToken(String token){
        return resetTokenRepository.findFirstByToken(token);
    }
}
