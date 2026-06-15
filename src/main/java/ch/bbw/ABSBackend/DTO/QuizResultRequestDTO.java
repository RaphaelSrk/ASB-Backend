package ch.bbw.ABSBackend.DTO;

import java.time.LocalDateTime;

public record QuizResultRequestDTO(
    Long categoryId,
    Integer totQuestion,
    Integer correctQuestion,
    LocalDateTime takenAt
) {
}
