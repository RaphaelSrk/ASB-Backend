package ch.bbw.ABSBackend.services;

import ch.bbw.ABSBackend.enteties.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
