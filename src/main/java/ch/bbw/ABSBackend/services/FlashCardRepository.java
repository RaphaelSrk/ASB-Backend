package ch.bbw.ABSBackend.services;

import ch.bbw.ABSBackend.enteties.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
}
