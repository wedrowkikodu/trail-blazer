package pl.wedrowkikodu.trailblazer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.trailblazer.model.entity.TravelLog;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @PatchMapping("/{id}")
    public ResponseEntity<TravelLog> partialUpdateTravelLog(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        TravelLog updatedTravelLog = new TravelLog();
        // logika częściowej aktualizacji dziennika podróży
        return ResponseEntity.ok().body(updatedTravelLog);
    }
}
