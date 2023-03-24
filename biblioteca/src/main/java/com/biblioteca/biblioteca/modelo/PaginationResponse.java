package com.biblioteca.biblioteca.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse {
    private Integer totalPages;
    private Integer paginaNumber;
    private Integer numeroResultado;

}
