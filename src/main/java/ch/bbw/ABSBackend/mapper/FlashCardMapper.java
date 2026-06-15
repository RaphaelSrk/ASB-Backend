package ch.bbw.ABSBackend.mapper;

import ch.bbw.ABSBackend.DTO.FlashCardRequestDTO;
import ch.bbw.ABSBackend.DTO.FlashCardResponseDTO;
import ch.bbw.ABSBackend.enteties.Category;
import ch.bbw.ABSBackend.enteties.FlashCard;

public class FlashCardMapper {

    public static FlashCardResponseDTO toDTO(FlashCard flashCard) {
        return new FlashCardResponseDTO(
                flashCard.getId(),
                flashCard.getQuestion(),
                flashCard.getAnswer(),
                flashCard.getAiGenerated(),
                flashCard.getCategory() != null ? flashCard.getCategory().getId() : null
        );
    }

    public static FlashCard fromDto(FlashCardRequestDTO dto) {
        FlashCard flashCard = new FlashCard();

        flashCard.setQuestion(dto.question());
        flashCard.setAnswer(dto.answer());
        flashCard.setAiGenerated(dto.aiGenerated());
        if (dto.categoryId() != null) {
            Category category = new Category();
            category.setId(dto.categoryId());
            flashCard.setCategory(category);
        }
        return flashCard;
    }
}
