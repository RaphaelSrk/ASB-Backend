package ch.bbw.ABSBackend.services;

import ch.bbw.ABSBackend.enteties.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {
}
