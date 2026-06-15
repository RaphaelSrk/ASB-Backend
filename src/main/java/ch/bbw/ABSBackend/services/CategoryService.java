package ch.bbw.ABSBackend.services;

import ch.bbw.ABSBackend.DTO.CategoryRequestDTO;
import ch.bbw.ABSBackend.DTO.CategoryResponseDTO;
import ch.bbw.ABSBackend.enteties.Category;
import ch.bbw.ABSBackend.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return repository.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        return repository.findById(id)
                .map(CategoryMapper::toDTO)
                .orElse(null);
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
        Category category = CategoryMapper.fromDto(dto);
        Category saved = repository.save(category);
        return CategoryMapper.toDTO(saved);
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {
        Category existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(dto.name());
        existing.setDescription(dto.description());
        Category saved = repository.save(existing);
        return CategoryMapper.toDTO(saved);
    }

    public boolean deleteCategory(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}