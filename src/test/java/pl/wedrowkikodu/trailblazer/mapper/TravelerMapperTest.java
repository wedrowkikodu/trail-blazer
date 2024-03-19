package pl.wedrowkikodu.trailblazer.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.wedrowkikodu.trailblazer.model.dto.TravelLogDto;
import pl.wedrowkikodu.trailblazer.model.dto.TravelerDto;
import pl.wedrowkikodu.trailblazer.model.entity.Traveler;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TravelerMapperTest {

    private static final String TEST_EMAIL = "test@email.com";
    private static final String TRAIL_NAME = "Trail blazer travel";
    private static final String TRAVELER_NAME = "John";

    @Mock
    private TravelerLogMapper travelerLogMapper;

    @InjectMocks
    private TravelerMapper travelerMapper;

    @Test
    public void shouldMapToTraveler() {
        TravelerDto dto = createTravelerDto();

        Traveler traveler = travelerMapper.mapToTraveler(dto);

        assertEquals(dto.id(), traveler.getId());
        assertEquals(dto.name(), traveler.getName());
        assertEquals(dto.email(), traveler.getEmail());
    }

    @Test
    public void shouldMapToDto() {
        Traveler traveler = createTraveler();

        when(travelerLogMapper.mapToDto(traveler.getTravelLogs()))
            .thenReturn(List.of(new TravelLogDto(1L, "2021-01-01", "Note example", TRAVELER_NAME, TRAIL_NAME)));
        TravelerDto dto = travelerMapper.mapToDto(traveler);

        assertEquals(traveler.getId(), dto.id());
        assertEquals(traveler.getName(), dto.name());
        assertEquals(traveler.getEmail(), dto.email());
        assertEquals(1, dto.travelLogs().size());
    }

    private TravelerDto createTravelerDto() {
        return new TravelerDto(1L, TRAVELER_NAME, TEST_EMAIL, Collections.emptyList());
    }

    private Traveler createTraveler() {
        Traveler traveler = new Traveler();
        traveler.setId(1L);
        traveler.setName(TRAVELER_NAME);
        traveler.setEmail(TEST_EMAIL);
        return traveler;
    }
}
