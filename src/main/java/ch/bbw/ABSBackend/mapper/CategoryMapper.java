package ch.bbw.ABSBackend.mapper;

import ch.bbw.ABSBackend.DTO.CategoryRequestDTO;
import ch.bbw.ABSBackend.DTO.CategoryResponseDTO;
import ch.bbw.ABSBackend.enteties.Category;
import ch.bbw.ABSBackend.enteties.FlashCard;

import java.util.List;

public class CategoryMapper {

    public static CategoryResponseDTO toDTO(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getFlashcards().stream()
                        .map(FlashCard::getId)
                        .toList()
        );
    }

    public static Category fromDto(CategoryRequestDTO dto) {
        List<FlashCard> ids = dto.flashCardIds().stream()
                .map(id -> {
                    FlashCard fc = new FlashCard(id);
                    return fc;
                })
                .toList();
        Category category = new Category();

        category.setName(dto.name());
        category.setDescription(dto.description());
        category.setFlashcards(ids);
        return category;
    }
}