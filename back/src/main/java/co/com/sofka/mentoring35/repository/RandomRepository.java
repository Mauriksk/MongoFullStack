package co.com.sofka.mentoring35.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.sofka.mentoring35.model.Loteria;
import co.com.sofka.mentoring35.model.Random;

public interface RandomRepository extends ReactiveCrudRepository<Random, String> {
    
}
