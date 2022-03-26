package co.com.sofka.mentoring35.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.sofka.mentoring35.model.Loteria;

public interface LoteriaRepository extends ReactiveCrudRepository<Loteria, String> {
    
}
