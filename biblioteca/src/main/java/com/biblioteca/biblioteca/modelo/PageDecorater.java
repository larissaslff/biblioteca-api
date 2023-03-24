package com.biblioteca.biblioteca.modelo;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageDecorater<T> {
    private final Page<T> page;

    public PageDecorater(Page<T> page) {
        this.page = page;
    }

    @JsonProperty("data") 
    public List<T> getContent() {
        return this.page.getContent();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public long getTotalElements() {
        return page.getTotalElements();
    }

    public long getPageNumber(){
        return page.getNumber();
    }

    
}
