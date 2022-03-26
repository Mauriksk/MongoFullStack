package co.com.sofka.mentoring35.controller;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.mentoring35.model.Loteria;
import co.com.sofka.mentoring35.model.Random;
import co.com.sofka.mentoring35.model.RequestDTO;
import co.com.sofka.mentoring35.repository.LoteriaRepository;
import co.com.sofka.mentoring35.repository.RandomRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class RandomController {

    private RandomRepository randomRepository;
    private LoteriaRepository loteriaRepository;

    @Autowired
    public RandomController(RandomRepository randomRepository, LoteriaRepository loteriaRepository) {
        this.randomRepository = randomRepository;
        this.loteriaRepository = loteriaRepository;
    }

    @PostMapping("/loteria")
    public Mono<Loteria> crearBoleto(@RequestBody Loteria loteria){
        return Mono.just(new Loteria() ).map( boleto ->{
            boleto.generarNumeroAletorio();
            return boleto;
        }).flatMap(loteriaRepository::save);
    }
    
    @GetMapping("/loteria")
    public Flux<Loteria> getTodosLosBoletos(){
        return loteriaRepository.findAll();
    }

    @PostMapping("")
    public Mono<Random> post(@RequestBody RequestDTO request) {
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(request.getList());
            return entity;
        }).map(entity -> {
            var list = Stream.of(request.getList().split(","))
                .map(p -> p.trim())
                .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(randomRepository::save);
    }

    
    @GetMapping("")
    public Flux<Random> get() {
        return randomRepository.findAll();
    }
    
}
