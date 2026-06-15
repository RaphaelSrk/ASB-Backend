package ch.bbw.ABSBackend.enteties;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer totQuestion;
    private Integer correctQuestion;
    private LocalDateTime takenAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getTotQuestion() {
        return totQuestion;
    }

    public void setTotQuestion(Integer totQuestion) {
        this.totQuestion = totQuestion;
    }

    public Integer getCorrectQuestion() {
        return correctQuestion;
    }

    public void setCorrectQuestion(Integer correctQuestion) {
        this.correctQuestion = correctQuestion;
    }

    public LocalDateTime getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(LocalDateTime takenAt) {
        this.takenAt = takenAt;
    }





}
