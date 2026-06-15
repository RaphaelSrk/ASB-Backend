package ch.bbw.ABSBackend.controller;

import ch.bbw.ABSBackend.DTO.QuizResultRequestDTO;
import ch.bbw.ABSBackend.DTO.QuizResultResponseDTO;
import ch.bbw.ABSBackend.services.QuizResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/quizresults")
@CrossOrigin(origins = "*")
public class QuizResultController {

    private final QuizResultService service;

    public QuizResultController(QuizResultService service) {
        this.service = service;
    }

    @GetMapping
    public List<QuizResultResponseDTO> getAllQuizResults() {
        return service.getAllQuizResults();
    }

    @GetMapping("/{id}")
    public QuizResultResponseDTO getQuizResultById(@PathVariable Long id) {
        return service.getQuizResultById(id);
    }

    @PostMapping
    public QuizResultResponseDTO createQuizResult(@RequestBody QuizResultRequestDTO quizResult) {
        return service.createQuizResult(quizResult);
    }

    @PutMapping("/{id}")
    public QuizResultResponseDTO updateQuizResult(@PathVariable Long id, @RequestBody QuizResultRequestDTO quizResult) {
        return service.updateQuizResult(id, quizResult);
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuizResult(@PathVariable Long id) {
        return service.deleteQuizResult(id);
    }
}
