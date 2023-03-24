package com.biblioteca.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.modelo.Autor;
import com.biblioteca.biblioteca.modelo.AutorDTO;
import com.biblioteca.biblioteca.repositories.AutorRepository;
import com.biblioteca.biblioteca.resource.exception.AutorNaoCadastradoException;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AutorDTO create(AutorDTO autorDTO) {
        autorRepository.save(mapper.map(autorDTO, Autor.class));
        return autorDTO;
    }

    @Override
    public List<AutorDTO> findAll() {
        List<Autor> listaAutor = autorRepository.findAll();
        List<AutorDTO> listaAutorDto = new ArrayList<>();
        for (Autor autor : listaAutor) {
            listaAutorDto.add(mapper.map(autor, AutorDTO.class));
        }
        return listaAutorDto;
    }

    @Override
    public Optional<AutorDTO> findById(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return Optional.of(mapper.map(autor.get(), AutorDTO.class));
        }

        else {
            throw new AutorNaoCadastradoException();
        }
    }

}
