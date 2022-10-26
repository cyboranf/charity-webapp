package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.Institution;
import pl.project.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Optional<Institution> findById(Long id) {
        return institutionRepository.findById(id);
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    public Institution save(Institution institution) {
        return institutionRepository.save(institution);
    }


}
