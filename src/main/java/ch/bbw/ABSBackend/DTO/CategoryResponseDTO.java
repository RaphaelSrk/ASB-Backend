package ch.bbw.ABSBackend.DTO;

import ch.bbw.ABSBackend.enteties.FlashCard;

import java.util.List;

public record CategoryResponseDTO(
        Long id,
        String name,
        String description,
        List<Long> flashCards
) {
}
