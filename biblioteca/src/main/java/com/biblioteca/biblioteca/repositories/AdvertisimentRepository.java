package com.biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.modelo.Advertisement;

public interface AdvertisimentRepository extends JpaRepository<Advertisement, Long> {
    
}
