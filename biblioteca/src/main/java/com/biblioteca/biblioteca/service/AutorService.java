package com.biblioteca.biblioteca.service;

import java.util.List;
import java.util.Optional;

import com.biblioteca.biblioteca.modelo.Autor;
import com.biblioteca.biblioteca.modelo.AutorDTO;

public interface AutorService {
    
    AutorDTO create(AutorDTO autorDTO);

    List<AutorDTO> findAll();

    Optional<AutorDTO> findById(Long id);
}
