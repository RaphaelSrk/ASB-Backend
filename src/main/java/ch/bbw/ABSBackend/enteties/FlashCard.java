package ch.bbw.ABSBackend.enteties;

import jakarta.persistence.*;

@Entity
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String question;

    @Lob
    private String answer;

    private Boolean AiGenerated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public FlashCard(Long id) {
        this.id = id;
    }

    public FlashCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getAiGenerated() {
        return AiGenerated;
    }

    public void setAiGenerated(Boolean aiGenerated) {
        AiGenerated = aiGenerated;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
