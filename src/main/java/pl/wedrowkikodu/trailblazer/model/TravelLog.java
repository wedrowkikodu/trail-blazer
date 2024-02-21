package pl.wedrowkikodu.trailblazer.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TravelLog {
    private Long id;
    private LocalDateTime date;
    private Trail trail;
    private Traveler traveler;
    private List<String> photos;
    private String notes;
}
