package pl.wedrowkikodu.trailblazer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.trailblazer.model.Trail;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trails")
public class TrailController {

    @GetMapping
    public List<Trail> getAllTrails() {
        // Logika pobierania wszystkich tras
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public Trail getTrailById(@PathVariable Long id) {
        // Logika pobierania trasy o danym ID
        return null;
    }

    @PostMapping
    public Trail createTrail(@RequestBody Trail trail) {
        // Logika dodawania nowej trasy
        return trail;
    }

    @PutMapping("/{id}")
    public Trail updateTrail(@PathVariable Long id, @RequestBody Trail trailDetails) {
        // Logika aktualizacji trasy
        return trailDetails;
    }

    @DeleteMapping("/{id}")
    public void deleteTrail(@PathVariable Long id) {
        // Logika usuwania trasy
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Trail> partialUpdateTrail(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Trail updatedTrail = new Trail();
        // logika częściowej aktualizacji trasy, gdzie updates to mapa klucz-wartość atrybutów do zmiany
        return ResponseEntity.ok().body(updatedTrail);
    }
}
