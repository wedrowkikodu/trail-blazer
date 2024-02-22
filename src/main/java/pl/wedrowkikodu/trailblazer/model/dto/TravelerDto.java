package pl.wedrowkikodu.trailblazer.model.dto;

import java.io.Serializable;
import java.util.List;

public record TravelerDto(Long id, String name, String email, List<TravelLogDto> travelLogs) implements Serializable {

}
