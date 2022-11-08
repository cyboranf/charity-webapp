package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.Authority;
import pl.project.charity.domain.ChangeToken;
import pl.project.charity.domain.User;
import pl.project.charity.domain.VerificationToken;
import pl.project.charity.repository.AuthorityRepository;
import pl.project.charity.repository.ChangeTokenRepository;
import pl.project.charity.repository.UserRepository;
import pl.project.charity.repository.VerificationTokenRepository;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final AuthorityRepository authorityRepository;
    private final ChangeTokenRepository changeTokenRepository;

    public UserService(UserRepository userRepository, VerificationTokenRepository verificationTokenRepository, AuthorityRepository authorityRepository, ChangeTokenRepository changeTokenRepository) {
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.authorityRepository = authorityRepository;
        this.changeTokenRepository = changeTokenRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findFirstById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByFirstName(username);
    }

    public void createVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setEmail(user.getEmail());
        verificationTokenRepository.save(verificationToken);
    }

    public void confirmUser(String token) {
        VerificationToken verificationToken=verificationTokenRepository.findFirstByToken(token);
        User user=userRepository.findFirstByEmail(verificationToken.getEmail());
        Authority authority=new Authority(user.getEmail(),"USER");
        user.setEnabled(true);
        userRepository.save(user);

        verificationTokenRepository.delete(verificationToken);
    }

    public void createChangeEmailToken(User user, String token) {
        ChangeToken changeToken = new ChangeToken();
        changeToken.setToken(token);
        changeToken.setEmail(user.getEmail());
        changeToken.setNewEmail(user.getChangeToken().getNewEmail());
        changeTokenRepository.save(changeToken);
    }

    public void confirmChangeEmail(String token) {
        //retrieve token
        ChangeToken changeToken = changeTokenRepository.findFirstByToken(token);

        //confirm change email
        User user = userRepository.findFirstByEmail(changeToken.getEmail());
        Authority authority = authorityRepository.findFirstByEmail(changeToken.getEmail());
        authority.setEmail(changeToken.getNewEmail());
        authorityRepository.save(authority);
        user.setEmail(changeToken.getNewEmail());
        userRepository.save(user);

        changeTokenRepository.delete(changeToken);
    }
}
