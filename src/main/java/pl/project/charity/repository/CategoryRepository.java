package pl.project.charity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.charity.domain.Category;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteAllById(Iterable<? extends Long> categories);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

}
