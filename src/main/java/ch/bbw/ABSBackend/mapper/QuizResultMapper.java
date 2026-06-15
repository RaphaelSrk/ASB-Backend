package ch.bbw.ABSBackend.mapper;

import ch.bbw.ABSBackend.DTO.QuizResultRequestDTO;
import ch.bbw.ABSBackend.DTO.QuizResultResponseDTO;
import ch.bbw.ABSBackend.enteties.Category;
import ch.bbw.ABSBackend.enteties.QuizResult;

public class QuizResultMapper {

    public static QuizResultResponseDTO toDTO(QuizResult quizResult) {
        return new QuizResultResponseDTO(
                quizResult.getId(),
                quizResult.getCategory() != null ? quizResult.getCategory().getId() : null,
                quizResult.getTotQuestion(),
                quizResult.getCorrectQuestion(),
                quizResult.getTakenAt()
        );
    }

    public static QuizResult fromDto(QuizResultRequestDTO dto) {
        QuizResult quizResult = new QuizResult();

        if (dto.categoryId() != null) {
            Category category = new Category();
            category.setId(dto.categoryId());
            quizResult.setCategory(category);
        }
        quizResult.setTotQuestion(dto.totQuestion());
        quizResult.setCorrectQuestion(dto.correctQuestion());
        quizResult.setTakenAt(dto.takenAt());
        return quizResult;
    }
}
