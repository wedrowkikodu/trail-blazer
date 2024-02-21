package pl.wedrowkikodu.trailblazer.model;

import lombok.Data;

import java.util.List;

@Data
public class Traveler {
    private Long id;
    private String username;
    private String email;
    private List<TravelLog> travelLogs;
}
