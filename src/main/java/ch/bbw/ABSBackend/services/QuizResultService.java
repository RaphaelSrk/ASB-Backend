package ch.bbw.ABSBackend.services;

import ch.bbw.ABSBackend.DTO.QuizResultRequestDTO;
import ch.bbw.ABSBackend.DTO.QuizResultResponseDTO;
import ch.bbw.ABSBackend.enteties.QuizResult;
import ch.bbw.ABSBackend.mapper.QuizResultMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuizResultService {

    private final QuizResultRepository repository;

    public QuizResultService(QuizResultRepository repository) {
        this.repository = repository;
    }

    public List<QuizResultResponseDTO> getAllQuizResults() {
        return repository.findAll()
                .stream()
                .map(QuizResultMapper::toDTO)
                .collect(Collectors.toList());
    }

    public QuizResultResponseDTO getQuizResultById(Long id) {
        return repository.findById(id)
                .map(QuizResultMapper::toDTO)
                .orElse(null);
    }

    public QuizResultResponseDTO createQuizResult(QuizResultRequestDTO dto) {
        QuizResult quizResult = QuizResultMapper.fromDto(dto);
        QuizResult saved = repository.save(quizResult);
        return QuizResultMapper.toDTO(saved);
    }

    public QuizResultResponseDTO updateQuizResult(Long id, QuizResultRequestDTO dto) {
        QuizResult existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setTotQuestion(dto.totQuestion());
        existing.setCorrectQuestion(dto.correctQuestion());
        existing.setTakenAt(dto.takenAt());
        QuizResult saved = repository.save(existing);
        return QuizResultMapper.toDTO(saved);
    }

    public boolean deleteQuizResult(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
