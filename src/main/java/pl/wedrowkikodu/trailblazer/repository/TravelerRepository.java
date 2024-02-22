package pl.wedrowkikodu.trailblazer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wedrowkikodu.trailblazer.model.entity.Traveler;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {

    
}
