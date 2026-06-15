package ch.bbw.ABSBackend.controller;

import ch.bbw.ABSBackend.DTO.FlashCardRequestDTO;
import ch.bbw.ABSBackend.DTO.FlashCardResponseDTO;
import ch.bbw.ABSBackend.services.FlashCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flashcards")
@CrossOrigin(origins = "*")
public class FlashCardController {

    private final FlashCardService service;

    public FlashCardController(FlashCardService service) {
        this.service = service;
    }

    @GetMapping
    public List<FlashCardResponseDTO> getAllFlashCards() {
        return service.getAllFlashCards();
    }

    @GetMapping("/{id}")
    public FlashCardResponseDTO getFlashCardById(@PathVariable Long id) {
        return service.getFlashCardById(id);
    }

    @PostMapping
    public FlashCardResponseDTO createFlashCard(@RequestBody FlashCardRequestDTO flashCard) {
        return service.createFlashCard(flashCard);
    }

    @PutMapping("/{id}")
    public FlashCardResponseDTO updateFlashCard(@PathVariable Long id, @RequestBody FlashCardRequestDTO flashCard) {
        return service.updateFlashCard(id, flashCard);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFlashCard(@PathVariable Long id) {
        return service.deleteFlashCard(id);
    }
}
