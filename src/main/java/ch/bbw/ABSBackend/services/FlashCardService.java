package ch.bbw.ABSBackend.services;

import ch.bbw.ABSBackend.DTO.FlashCardRequestDTO;
import ch.bbw.ABSBackend.DTO.FlashCardResponseDTO;
import ch.bbw.ABSBackend.enteties.FlashCard;
import ch.bbw.ABSBackend.mapper.FlashCardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlashCardService {

    private final FlashCardRepository repository;

    public FlashCardService(FlashCardRepository repository) {
        this.repository = repository;
    }

    public List<FlashCardResponseDTO> getAllFlashCards() {
        return repository.findAll()
                .stream()
                .map(FlashCardMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FlashCardResponseDTO getFlashCardById(Long id) {
        return repository.findById(id)
                .map(FlashCardMapper::toDTO)
                .orElse(null);
    }

    public FlashCardResponseDTO createFlashCard(FlashCardRequestDTO dto) {
        FlashCard flashCard = FlashCardMapper.fromDto(dto);
        FlashCard saved = repository.save(flashCard);
        return FlashCardMapper.toDTO(saved);
    }

    public FlashCardResponseDTO updateFlashCard(Long id, FlashCardRequestDTO dto) {
        FlashCard existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setQuestion(dto.question());
        existing.setAnswer(dto.answer());
        existing.setAiGenerated(dto.aiGenerated());
        FlashCard saved = repository.save(existing);
        return FlashCardMapper.toDTO(saved);
    }

    public boolean deleteFlashCard(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
