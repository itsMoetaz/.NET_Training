package com.esprit.microservice.candidat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/candidats")
@RestController
@Tag(name = "Candidat-MicroService")
public class CandidatRestAPI {
    @Autowired
    private ICandidatService icandidatService;
    private String title = "Hello, i'm the candidate Micro-Service";

    @RequestMapping("/hello")
    @Operation(description = "just say hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @RequestMapping
    public ResponseEntity<List<Candidat>> getAll() {
        return new ResponseEntity<List<Candidat>>(icandidatService.getAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(icandidatService.addCandidat(candidat), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Candidat candidat) {
        return new ResponseEntity<>(icandidatService.updateCandidat(id, candidat),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(icandidatService.deleteCandidat(id), HttpStatus.OK);
    }

}
