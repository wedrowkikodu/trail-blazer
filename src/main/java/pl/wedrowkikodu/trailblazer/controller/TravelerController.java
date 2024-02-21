package pl.wedrowkikodu.trailblazer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.trailblazer.model.Traveler;
import pl.wedrowkikodu.trailblazer.service.TravelerService;

import java.util.List;

@RestController
@RequestMapping("/travelers")
public class TravelerController {

    private final TravelerService travelerService;

    @Autowired
    public TravelerController(TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @GetMapping
    public ResponseEntity<List<Traveler>> getAllTravelers() {
        List<Traveler> travelers = travelerService.findAll();
        return new ResponseEntity<>(travelers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traveler> getTravelerById(@PathVariable Long id) {
        Traveler traveler = travelerService.findById(id)
            .orElseThrow(() -> new RuntimeException("Traveler not found with id: " + id));
        return new ResponseEntity<>(traveler, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Traveler> createTraveler(@RequestBody Traveler traveler) {
        Traveler newTraveler = travelerService.save(traveler);
        return new ResponseEntity<>(newTraveler, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traveler> updateTraveler(@PathVariable Long id, @RequestBody Traveler travelerDetails) {
        Traveler updatedTraveler = travelerService.update(id, travelerDetails);
        return new ResponseEntity<>(updatedTraveler, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTraveler(@PathVariable Long id) {
        travelerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
