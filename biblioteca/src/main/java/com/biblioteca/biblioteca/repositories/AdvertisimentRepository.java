package com.biblioteca.biblioteca.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.modelo.Advertisiment;


public interface AdvertisimentRepository extends JpaRepository<Advertisiment, Long> {
}
