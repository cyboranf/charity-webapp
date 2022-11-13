package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.Authority;
import pl.project.charity.repository.AuthorityRepository;

@Service
@Transactional
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority findFirstBtEmail(String email){
        return authorityRepository.findFirstByEmail(email);
    }

    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }
    public void delete(Authority authority){
        authorityRepository.delete(authority);
    }
}
