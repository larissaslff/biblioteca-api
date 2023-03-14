package com.biblioteca.biblioteca.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<AutorDTO> createAutor(@RequestBody AutorDTO autorDTO, UriComponentsBuilder uriBuilder) {
        Autor autor = repository.save(mapper.map(autorDTO, Autor.class));
        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(autorDTO);

    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAllAutores(){
        List<Autor> autores = repository.findAll();
        List<AutorDTO> retorno = new ArrayList<>();
        for (Autor autor : autores) {
            retorno.add(mapper.map(autor, AutorDTO.class));
        }
        return ResponseEntity.ok().body(retorno);
    }

}
