package pl.wedrowkikodu.trailblazer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wedrowkikodu.trailblazer.exception.ResourceNotFoundException;
import pl.wedrowkikodu.trailblazer.model.entity.Traveler;
import pl.wedrowkikodu.trailblazer.repository.TravelerRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;

    @Override
    public List<Traveler> findAll() {
        return travelerRepository.findAll();
    }

    @Override
    public Optional<Traveler> findById(Long id) {
        return travelerRepository.findById(id);
    }

    @Override
    public Traveler save(Traveler object) {
        return travelerRepository.save(object);
    }

    @Override
    public Traveler update(Long id, Traveler objectDetails) {
        Traveler traveler = travelerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Traveler not found with id: " + id));
        updateTraveler(traveler, objectDetails);

        return travelerRepository.save(traveler);
    }

    private void updateTraveler(Traveler traveler, Traveler objectDetails) {
        traveler.setName(objectDetails.getName());
        traveler.setEmail(objectDetails.getEmail());
        updateTravelLogs(traveler, objectDetails);
    }

    private void updateTravelLogs(Traveler traveler, Traveler objectDetails) {
        traveler.getTravelLogs().clear();
        traveler.getTravelLogs().addAll(objectDetails.getTravelLogs());
    }

    @Override
    public void delete(Long id) {
        travelerRepository.findById(id)
            .ifPresentOrElse(travelerRepository::delete, () -> {
                throw new ResourceNotFoundException("Traveler not found with id: " + id);
            });
    }
}
