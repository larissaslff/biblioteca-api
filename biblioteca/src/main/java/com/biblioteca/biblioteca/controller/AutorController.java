package com.biblioteca.biblioteca.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.biblioteca.biblioteca.modelo.Autor;
import com.biblioteca.biblioteca.modelo.AutorDTO;
import com.biblioteca.biblioteca.repositories.AutorRepository;
import com.biblioteca.biblioteca.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private AutorService autorService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<AutorDTO> createAutor(@RequestBody AutorDTO autorDTO, UriComponentsBuilder uriBuilder) {
        Autor autor = repository.save(mapper.map(autorDTO, Autor.class));
        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(autorDTO);

    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAllAutores(){
        return ResponseEntity.ok().body(autorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AutorDTO>> findById(@PathVariable Long id) {
        Optional<AutorDTO> autorDto = autorService.findById(id);
        return new ResponseEntity<Optional<AutorDTO>>(autorDto, HttpStatus.OK);
    }

}
