package ch.bbw.ABSBackend.DTO;

public record FlashCardResponseDTO(
        Long id,
        String question,
        String answer,
        Boolean aiGenerated,
        Long categoryId
) {
}
