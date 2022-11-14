package pl.project.charity.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.ResetToken;
import pl.project.charity.domain.User;
import pl.project.charity.models.Password;
import pl.project.charity.repository.PasswordRepository;
import pl.project.charity.repository.ResetTokenRepository;
import pl.project.charity.repository.UserRepository;

@Service
@Transactional
public class PasswordService implements PasswordRepository{
    private final ResetTokenRepository resetTokenRepository;
    private final UserRepository userRepository;

    public PasswordService(ResetTokenRepository resetTokenRepository, UserRepository userRepository) {
        this.resetTokenRepository = resetTokenRepository;
        this.userRepository = userRepository;
    }


    public void createResetToken(@NotNull Password password, String token) {
        ResetToken resetToken = new ResetToken();
        resetToken.setToken(token);
        resetToken.setEmail(password.getEmail());
        resetTokenRepository.save(resetToken);
    }


    public void update(@NotNull Password password) {
        User user = userRepository.findFirstByEmail(password.getEmail());
        user.setPassword(password.getNewPassword());
        userRepository.save(user);

        ResetToken resetToken = resetTokenRepository.findFirstByToken(password.getToken());
        resetTokenRepository.delete(resetToken);
    }
}
