package pl.wedrowkikodu.trailblazer.service;

import java.util.List;
import java.util.Optional;

public interface BaseCrudService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T object);
    T update(Long id, T objectDetails);
    void delete(Long id);
}
