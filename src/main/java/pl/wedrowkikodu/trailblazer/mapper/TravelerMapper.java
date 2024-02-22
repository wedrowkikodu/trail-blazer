package pl.wedrowkikodu.trailblazer.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.wedrowkikodu.trailblazer.model.dto.TravelerDto;
import pl.wedrowkikodu.trailblazer.model.entity.Traveler;

@RequiredArgsConstructor
@Component
public class TravelerMapper {

    private final TravelerLogMapper travelerLogMapper;

    public Traveler mapToTraveler(TravelerDto dto) {
        Traveler traveler = new Traveler();
        traveler.setId(dto.id());
        traveler.setName(dto.name());
        traveler.setEmail(dto.email());
        return new Traveler();
    }

    public TravelerDto mapToDto(Traveler traveler) {
        return new TravelerDto(traveler.getId(), traveler.getName(), traveler.getEmail(),
            travelerLogMapper.mapToDto(traveler.getTravelLogs()));
    }

}
