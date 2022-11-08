package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.ChangeToken;
import pl.project.charity.repository.ChangeTokenRepository;

@Service
@Transactional
public class ChangeTokenService {
    private final ChangeTokenRepository changeTokenRepository;

    public ChangeTokenService(ChangeTokenRepository changeTokenRepository) {
        this.changeTokenRepository = changeTokenRepository;
    }

    public ChangeToken findFirstByToken(String token){
        return changeTokenRepository.findFirstByToken(token);
    }
}
