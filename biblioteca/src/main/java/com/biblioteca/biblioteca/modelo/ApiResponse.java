package com.biblioteca.biblioteca.modelo;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private Page<Advertisement> data;
    private PaginationResponse paginationResponse;
}
