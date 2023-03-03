package com.biblioteca.biblioteca.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.biblioteca.biblioteca.modelo.Autor;
import com.biblioteca.biblioteca.modelo.AutorDTO;
import com.biblioteca.biblioteca.repositories.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<AutorDTO> create(@RequestBody AutorDTO autorDTO, UriComponentsBuilder uriBuilder) {
        Autor autor = repository.save(mapper.map(autorDTO, Autor.class));
        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(autorDTO);

    }
}
