package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.modelo.PageDecorater;
import com.biblioteca.biblioteca.service.AdvertisimentServiceImpl;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    public AdvertisimentServiceImpl service;

    @GetMapping
    public ResponseEntity<PageDecorater> show(@RequestParam(required = false) String state, 
                                    @RequestParam(required = false) String titule,
                                    @RequestParam(required = false) Integer size,
                                    @RequestParam(required = false) Integer pagenumber){

        Pageable pagination = PageRequest.of(pagenumber, size);
        return ResponseEntity.ok(service.findAllBY(pagination, state, titule));
    }

}
