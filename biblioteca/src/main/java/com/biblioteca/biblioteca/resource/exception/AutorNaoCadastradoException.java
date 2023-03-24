package com.biblioteca.biblioteca.resource.exception;

public class AutorNaoCadastradoException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Autor não cadastrado";
    }

}
    
