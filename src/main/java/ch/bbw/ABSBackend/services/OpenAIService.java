package ch.bbw.ABSBackend.services;
import ch.bbw.ABSBackend.model.*;

public interface OpenAIService {
    GeneratedFlashCardResponse getFlashCard(GeneratedFlashCardRequest request);
}

