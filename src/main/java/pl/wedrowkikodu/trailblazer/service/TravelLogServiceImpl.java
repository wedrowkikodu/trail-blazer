package pl.wedrowkikodu.trailblazer.service;

import org.springframework.stereotype.Service;
import pl.wedrowkikodu.trailblazer.model.entity.TravelLog;

import java.util.List;
import java.util.Optional;

@Service
public class TravelLogServiceImpl implements TravelLogService {

    @Override
    public List<TravelLog> findAll() {
        return null;
    }

    @Override
    public Optional<TravelLog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TravelLog save(TravelLog object) {
        return null;
    }

    @Override
    public TravelLog update(Long id, TravelLog objectDetails) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
