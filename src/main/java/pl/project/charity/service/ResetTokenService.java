package pl.project.charity.service;

import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.ResetToken;
import pl.project.charity.repository.ResetTokenRepository;

@Service
@Transactional
@Data
public class ResetTokenService {
    private final ResetTokenRepository resetTokenRepository;


    public ResetToken findFirstByToken(String token){
        return resetTokenRepository.findFirstByToken(token);
    }
    public void save(ResetToken resetToken){
        resetTokenRepository.save(resetToken);
    }
    public void delete(ResetToken resetToken){
        resetTokenRepository.delete(resetToken);
    }


}
