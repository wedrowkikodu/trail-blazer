package pl.wedrowkikodu.trailblazer.controller;

import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.trailblazer.model.TravelLog;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/travelLogs")
public class TravelLogController {

    @GetMapping
    public List<TravelLog> getAllTravelLogs() {
        // Logika pobierania wszystkich dzienników podróży
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public TravelLog getTravelLogById(@PathVariable Long id) {
        // Logika pobierania dziennika podróży o danym ID
        return null;
    }

    @PostMapping
    public TravelLog createTravelLog(@RequestBody TravelLog travelLog) {
        // Logika dodawania nowego dziennika podróży
        return travelLog;
    }

    @PutMapping("/{id}")
    public TravelLog updateTravelLog(@PathVariable Long id, @RequestBody TravelLog travelLogDetails) {
        // Logika aktualizacji dziennika podróży
        return travelLogDetails;
    }

    @DeleteMapping("/{id}")
    public void deleteTravelLog(@PathVariable Long id) {
        // Logika usuwania dziennika podróży
    }
}
