package pl.wedrowkikodu.trailblazer.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.wedrowkikodu.trailblazer.model.dto.TravelLogDto;
import pl.wedrowkikodu.trailblazer.model.entity.TravelLog;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TravelerLogMapper {

    public List<TravelLogDto> mapToDto(List<TravelLog> travelLogs) {
        return travelLogs.stream()
            .map(this::mapToDto)
            .toList();
    }

    public TravelLogDto mapToDto(TravelLog travelLog) {
        return new TravelLogDto(travelLog.getId(), travelLog.getDate().toString(), travelLog.getNotes(),
            travelLog.getTraveler().getName(), travelLog.getTrail().getName());
    }

}
