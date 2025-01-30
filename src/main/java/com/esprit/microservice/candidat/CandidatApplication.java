package com.esprit.microservice.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidatApplication.class, args);
    }
    @Autowired
    private CandidatRepository candidatRepository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            candidatRepository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
            candidatRepository.save(new Candidat("Sarra", "ab", "sa@esprit.tn"));
            candidatRepository.save(new Candidat("Mohamed", "ba", "mo@esprit.tn"));
            candidatRepository.save(new Candidat("Maroua", "dh", "maroua@esprit.tn"));
// fetch
            candidatRepository.findAll().forEach(System.out::println);
        };

}}
