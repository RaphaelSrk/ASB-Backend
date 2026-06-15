package ch.bbw.ABSBackend.DTO;

import java.time.LocalDateTime;

public record QuizResultResponseDTO(
        Long id,
        Long categoryId,
        Integer totQuestion,
        Integer correctQuestion,
        LocalDateTime takenAt
) {
}
