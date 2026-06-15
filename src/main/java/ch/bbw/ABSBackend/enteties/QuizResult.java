package ch.bbw.ABSBackend.enteties;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer totQuestion;
    private Integer correctQuestion;
    private LocalDateTime takenAt;





}
