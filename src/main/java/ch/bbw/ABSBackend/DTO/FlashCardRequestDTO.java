package ch.bbw.ABSBackend.DTO;

public record FlashCardRequestDTO(
    String question,
    String answer,
    Boolean aiGenerated,
    Long categoryId
) {
}
