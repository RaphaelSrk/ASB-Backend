package ch.bbw.ABSBackend.DTO;

import java.util.List;

public record CategoryRequestDTO(
    String name,
    String description,
    List<Long> flashCardIds
) {
}
