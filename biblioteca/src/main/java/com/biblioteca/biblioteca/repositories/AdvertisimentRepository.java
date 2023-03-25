package com.biblioteca.biblioteca.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import com.biblioteca.biblioteca.modelo.Advertisiment;
import com.biblioteca.biblioteca.modelo.State;


public interface AdvertisimentRepository extends JpaRepository<Advertisiment, Long>, JpaSpecificationExecutor<Advertisiment> {

    @Query("Select a from Advertisiment a where (a.titule= null or a.titule LIKE %:titule%) or (a.state= null or a.state=:state)")
    Page<Advertisiment>findByStatusActive(String titule, State state, Pageable pageable);
}
