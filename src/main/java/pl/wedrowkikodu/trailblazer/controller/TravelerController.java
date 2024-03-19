package pl.wedrowkikodu.trailblazer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.trailblazer.exception.ResourceNotFoundException;
import pl.wedrowkikodu.trailblazer.mapper.TravelerMapper;
import pl.wedrowkikodu.trailblazer.model.dto.TravelerDto;
import pl.wedrowkikodu.trailblazer.model.entity.Traveler;
import pl.wedrowkikodu.trailblazer.service.TravelerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/travelers")
public class TravelerController {

    private final TravelerMapper travelerMapper;
    private final TravelerService travelerService;

    @GetMapping
    public ResponseEntity<List<TravelerDto>> getAllTravelers() {
        List<Traveler> travelers = travelerService.findAll();
        return new ResponseEntity<>(travelers.stream().map(travelerMapper::mapToDto).toList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelerDto> getTravelerById(@PathVariable Long id) {
        Traveler traveler = travelerService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Traveler not found with id: " + id));
        return new ResponseEntity<>(travelerMapper.mapToDto(traveler), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TravelerDto> createTraveler(@RequestBody Traveler traveler) {
        Traveler newTraveler = travelerService.save(traveler);
        return new ResponseEntity<>(travelerMapper.mapToDto(newTraveler), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelerDto> updateTraveler(@PathVariable Long id, @RequestBody Traveler travelerDetails) {
        Traveler updatedTraveler = travelerService.update(id, travelerDetails);
        return new ResponseEntity<>(travelerMapper.mapToDto(updatedTraveler), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTraveler(@PathVariable Long id) {
        travelerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
