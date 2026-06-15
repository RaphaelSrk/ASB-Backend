package ch.bbw.ABSBackend.enteties;

import jakarta.persistence.*;

@Entity
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String question;

    @Lob
    private String answer;

    private Boolean AiGenerated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
